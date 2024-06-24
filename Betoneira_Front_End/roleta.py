from PPlay.window import *
from PPlay.sprite import *
from math import *
from PPlay.mouse import *
import sys

def roleta(tipo, opt, email, quantia, odd):
    retorno = False
    janela = Window(1280, 720)
    mouse = Mouse()
    parar = Sprite("Sprites/Parar.jpg")
    parar.set_position(janela.width - parar.width - 80, janela.height - parar.height - 80)
    seta = Sprite("Sprites/seta(1).png")
    seta.set_position(janela.width/2 - seta.width/2, janela.height - seta.height)
    bola1 = Sprite("Sprites/1.png")
    bola2 = Sprite("Sprites/2.png")
    bola3 = Sprite("Sprites/3.png")
    bola4 = Sprite("Sprites/4.png")
    bola5 = Sprite("Sprites/5.png")
    bola6 = Sprite("Sprites/6.png")
    bola7 = Sprite("Sprites/7.png")
    bola8 = Sprite("Sprites/8.png")
    bola9 = Sprite("Sprites/9.png")
    bolas = [bola1, bola2, bola3, bola4, bola5, bola6, bola7, bola8, bola9]
    for i, v in enumerate(bolas):
        v.set_position(janela.width/2 - v.width/2 + 170*cos((i*2)*pi/9 ), janela.height/2 - v.height/2 + 170*sin((i*2)*pi/9))
    add = 0
    parou = False
    parouMesmo = False
    parouMesmoMesmo = False
    vel = 5
    timer = 0
    while True:
        if (mouse.is_button_pressed(1) and parar.x<mouse.get_position()[0]<(parar.x+parar.width) and parar.y<mouse.get_position()[1]<(parar.y+parar.height) and parou == False):
            parou = True
            resultado = getResultadoRoleta(tipo, opt, email, quantia)
        if parou and not parouMesmo:
            vel -= 1.2*janela.delta_time()
        if vel < 0.5:
            parouMesmo = True
        if parouMesmo and janela.width/2 - 2 < bolas[resultado-1].x + bolas[resultado-1].width/2 < janela.width/2 + 2 and bolas[resultado-1].y > janela.height/2:
            vel = 0
            parouMesmoMesmo = True
        if parouMesmoMesmo:
            timer += janela.delta_time()
        if timer > 5:
            ganhou = False
            if tipo == "num" and resultado == opt:
                ganhou = True
            elif tipo == "cor":
                if opt == 3 and resultado == 1:
                    ganhou = True
                elif opt == 2 and (resultado == 2 or resultado == 4 or resultado == 6 or resultado == 8):
                    ganhou = True
                elif opt == 1 and (resultado == 3 or resultado == 5 or resultado == 7 or resultado == 9):
                    ganhou = True
            retorno = telaResultado(janela, ganhou, quantia, odd)
            break
        add += vel*janela.delta_time()
        janela.set_background_color([50, 50, 50])
        for i, v in enumerate(bolas):
            v.set_position(janela.width/2 - v.width/2 + 170*cos((i*2)*pi/9 + add), janela.height/2 - v.height/2 + 170*sin((i*2)*pi/9 + add))
            v.draw()
        parar.draw()
        seta.draw()
        janela.update()
    #janela.close()
    return retorno

def telaResultado(janela, ganhou, quantia, odd):
    if ganhou:
        txt = "ganhou"
        valor = quantia * odd
    else:
        txt = "perdeu"
        valor = quantia
    sair = Sprite("Sprites/Sair.jpg")
    aptnov = Sprite("Sprites/ApostarNovamente.jpg")
    sair.set_position(janela.width/2 - sair.width/2, 550)
    aptnov.set_position(janela.width/2 - aptnov.width/2, 400)
    mouse = Mouse()
    mouseClicked = False
    signal = False
    positionx = -1
    positiony = -1
    retorno = False
    while True:
        if not mouseClicked and mouse.is_button_pressed(1):
            mouseClicked = True
            positionx = mouse.get_position()[0]
            positiony = mouse.get_position()[1]
        if mouseClicked and not mouse.is_button_pressed(1):
            signal = True
        '''if signal:
            if (sair.x < positionx < sair.x + sair.width) and (sair.y < positiony < sair.y + sair.height):
                retorno = False
            elif (aptnov.x < positionx < aptnov.x + aptnov.width) and (aptnov.y < positiony < aptnov.y + aptnov.height):
                retorno = True
            break
        '''
        if signal and (sair.x < positionx < sair.x + sair.width) and (sair.y < positiony < sair.y + sair.height):
                retorno = False
                break
        elif signal and (aptnov.x < positionx < aptnov.x + aptnov.width) and (aptnov.y < positiony < aptnov.y + aptnov.height):
                retorno = True
                break

        janela.set_background_color([50, 50, 50])
        janela.draw_text(f"Você {txt} V${valor}!", 400, 150, size=60, color=(255,255,255), font_name='Candara')
        sair.draw()
        aptnov.draw()
        janela.update()
        signal = False
    return retorno


# requisição

def getResultadoRoleta(tipo, opt, email, quantia):
    return 1



tipo = sys.argv[1]
opt = sys.argv[2]
try:
    opt = int(opt)       # precisa tratar mais
except ValueError:
    pass
email = sys.argv[3]
quantia = float(sys.argv[4])
odd = float(sys.argv[5])
rsp = roleta(tipo, opt, email, quantia, odd)
if rsp:
    ret = 0
else:
    ret = 1
sys.exit(ret)