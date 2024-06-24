from PPlay.window import *
from PPlay.sprite import *

def aviao(quantia, email):
    janela = Window(1280, 720)
    janela.set_background_color([0, 0, 0])
    fundo = Sprite("Sprites/Espaço.jpg")
    fundo.set_position(0, janela.height - fundo.height)
    aviao = Sprite("Sprites/Avião.png")
    aviao.set_position(0, janela.height - aviao.height)
    velFundo = 40
    velAviao = 60
    meio = False
    dy = janela.height / janela.width
    dx = 1
    while True:
        if meio:
            velFundo+=0.1
            if fundo.x + fundo.width < janela.width:
                fundo.x = 0
            if fundo.y > 0:
                fundo.y = janela.height - fundo.height
            fundo.x -= velFundo*janela.delta_time()
            fundo.y += velFundo*janela.delta_time()
        else:
            aviao.x += dx*velAviao*janela.delta_time()
            aviao.y -= dy*velAviao*janela.delta_time()
            if janela.width/2 - 5 < aviao.x + aviao.width/2 < janela.width/2 + 5 and janela.height/2 - 30 < aviao.y + aviao.height/2 < janela.height/2 + 30:
                meio = True
        fundo.draw()
        aviao.draw()
        janela.update()