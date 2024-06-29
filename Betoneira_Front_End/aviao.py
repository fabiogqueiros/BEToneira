from PPlay.window import *
from PPlay.sprite import *
from PPlay.mouse import *
import sys
from random import randint
from queries import começar, crashou, pararReq

def aviao(quantia, email):
    janela = Window(1280, 720)
    janela.set_background_color([0, 0, 0])
    fundo = Sprite("Sprites/Espaço.jpg")
    fundo.set_position(0, janela.height - fundo.height)
    aviao = Sprite("Sprites/Avião.png")
    aviao.set_position(0, janela.height - aviao.height)
    parar = Sprite("Sprites/Parar.jpg")
    parar.set_position(janela.width - parar.width - 80, janela.height - parar.height - 80)
    explosao = Sprite("Sprites/Explosão.png")
    explosao.set_position(janela.width/2 - explosao.width/2, janela.height/2 - explosao.height/2)
    sair = Sprite("Sprites/Sair.jpg")
    aptnov = Sprite("Sprites/ApostarNovamente.jpg")
    sair.set_position(1180 - sair.width, janela.height - 200)
    aptnov.set_position(1180 - aptnov.width, janela.height - 100)
    velFundo = 40
    velAviao = 90
    meio = False
    dy = janela.height / janela.width
    dx = 1
    mouse = Mouse()
    mouseClicked = False
    signal = False
    parou = False
    multiplicador = 1
    tempoAcumulado = 0
    crash = False
    multiplicadorReal = 1
    tempoDeCheck = 0
    while True:
        if tempoAcumulado > tempoDeCheck:
            tempoDeCheck += 1
            crash = crashou()
        multiplicador = função(tempoAcumulado)
        fundo.draw()
        if not mouseClicked and mouse.is_button_pressed(1):
            mouseClicked = True
            positionx = mouse.get_position()[0]
            positiony = mouse.get_position()[1]
        if mouseClicked and not mouse.is_button_pressed(1):
            signal = True
        if meio and not parou and not crash:
            if signal and (parar.x < positionx < parar.x + parar.width) and (parar.y < positiony < parar.y + parar.height):
                    parou = True
                    #multiplicadorReal = pararReq(email)  #É o que é pra acontecer de fato
                    multiplicadorReal = multiplicador  # Fake
            tempoAcumulado += janela.delta_time()
            parar.draw()
            velFundo+=0.1
            if fundo.x + fundo.width < janela.width:
                fundo.x = 0
            if fundo.y > 0:
                fundo.y = janela.height - fundo.height
            fundo.x -= velFundo*janela.delta_time()
            fundo.y += velFundo*janela.delta_time()
            aviao.draw()
        elif crash:
            multiplicador = 0
            explosao.draw()
        elif parou:
            aviao.draw()
        elif not parou:
            aviao.x += dx*velAviao*janela.delta_time()
            aviao.y -= dy*velAviao*janela.delta_time()
            if janela.width/2 - 6 < aviao.x + aviao.width/2 < janela.width/2 + 6 and janela.height/2 - 30 < aviao.y + aviao.height/2 < janela.height/2 + 30:
                meio = True
                começar(email, quantia)
            aviao.draw()
        if parou or crash:
            if parou:
                txt1 = "Você ganhou"
                txt2 = f"V${(multiplicadorReal*quantia):.2f}!"
            else:
                txt1 = "Você perdeu!"
                txt2 = ""
            sair.draw()
            aptnov.draw()
            if len(txt2) > 11:
                janela.draw_text(txt1, 850, 150, size=40, color=(255,255,0), font_name='Candara')
                janela.draw_text(txt2, 850, 185, size=40, color=(255,255,0), font_name='Candara')
            else:
                janela.draw_text(txt1+' '+txt2, 850, 150, size=40, color=(255,255,0), font_name='Candara')
            if mouse.is_button_pressed(1) and (sair.x < mouse.get_position()[0] < sair.x + sair.width) and (sair.y < mouse.get_position()[1] < sair.y + sair.height):
                return False
            elif mouse.is_button_pressed(1) and (aptnov.x < mouse.get_position()[0] < aptnov.x + aptnov.width) and (aptnov.y < mouse.get_position()[1] < aptnov.y + aptnov.height):
                return True
        janela.draw_text(f"Multiplicador: {multiplicador:.2f}", 850, 70, size=45, color=(255,255,0), font_name='Candara')
        janela.update()
        signal = False

def função(x):
    return x**(2) / 300 + 1


quantia = float(sys.argv[1])
email = sys.argv[2]
rsp = aviao(quantia, email)

if rsp:
    ret = 0
else:
    ret = 1
sys.exit(ret)