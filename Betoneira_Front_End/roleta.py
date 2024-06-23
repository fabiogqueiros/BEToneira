from PPlay.window import *
from PPlay.sprite import *
from math import *

def roleta(tipo, opt, email, quantia):
    janela = Window(1280, 720)
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
    while True:
        add += 5*janela.delta_time()
        janela.set_background_color([50, 50, 50])
        for i, v in enumerate(bolas):
            v.set_position(janela.width/2 - v.width/2 + 170*cos((i*2)*pi/9 + add), janela.height/2 - v.height/2 + 170*sin((i*2)*pi/9 + add))
            v.draw()
        janela.update()