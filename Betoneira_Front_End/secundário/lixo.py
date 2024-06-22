#login.py

from classes import *
from PPlay.keyboard import *
def login(janela):
    t =Text_field(300, 300, janela)
    teclado = Keyboard()
    kbc = KeyboardController()
    while True:
        janela.set_background_color([35,35,35])
        janela.draw_text("Login", janela.width/2 - 100, 90, 50, (255,255,255))
        c = kbc.getKeyPressed(teclado)
        
        if c != '':
            print(c)
            t.write(c)
        t.draw()
        janela.update()






# keyboard.py

# coding= utf-8

import pygame
from pygame.locals import *

# Initializes pygame's modules
pygame.init()

class Keyboard():
    """
    Returns True if the key IS pressed, it means
    the press-check occurs every frame
    """
    def key_pressed(self, key):
        key = self.to_pattern(key)
        keys = pygame.key.get_pressed()
        if(keys[key]):
            return True

        return False
    
    """Shows the int code of the key"""
    def show_key_pressed(self):
        events = pygame.event.get()
        for event in events:
            if event.type == pygame.KEYDOWN:
                print(event.key)
                
    def to_pattern(self, key):
        if((key=="LEFT") or (key=="left")):
            return pygame.K_LEFT
        elif((key=="RIGHT") or (key=="right")):
            return pygame.K_RIGHT
        elif((key=="UP") or (key=="up")):
            return pygame.K_UP
        elif((key=="DOWN") or (key=="down")):
            return pygame.K_DOWN
        elif((key=="ENTER") or (key=="enter") or
             (key=="RETURN") or (key=="return")):
            return pygame.K_RETURN
        elif((key=="ESCAPE") or (key=="escape") or
             (key=="ESC") or (key=="esc")):
            return pygame.K_ESCAPE
        elif((key=="SPACE") or (key=="space")):
            return pygame.K_SPACE
        elif((key=="LEFT_CONTROL") or (key=="left_control")):
            return pygame.K_LCTRL
        elif((key=="LEFT_SHIFT") or (key=="left_shift")):
            return pygame.K_LSHIFT
        elif(((key >= "A") and (key <= "Z")) or
             ((key  >= "a") and (key <= "z"))):
            return getattr(pygame, "K_" + key.lower())
        elif((key >= "0") and (key <= "9")):
            return getattr(pygame, "K_" + key)
        return key

# classes.py

from PPlay import *
from PPlay.sprite import *

class Window(window.Window):
    def draw_vline(self, x, y, h=720):
        q = h//100
        for i in range(q):
            s = Sprite("Sprites/preto.jpg")
            s.set_position(x, y + i*100)
            s.draw()
        s = Sprite("Sprites/preto.jpg")
        s.set_position(x, y + h - 100)
        s.draw()

    def draw_hline(self, x, y, w=200):
        q = w//133
        for i in range(q):
            s = Sprite("Sprites/pretoh.jpg")
            s.set_position(x + i*133, y)
            s.draw()
        s = Sprite("Sprites/pretoh.jpg")
        s.set_position(x + w - 133, y)
        s.draw()
        
class Text_field(Sprite):
    qtd = 0
    ativo = 0
    def __init__(self, x, y, janela) -> None:
        super().__init__("Sprites/pretoh.jpg")
        Text_field.qtd += 1
        self.id = Text_field.qtd
        super().set_position(x, y)
        self.text = 'aaa'
        self.janela = janela
    def draw(self):
        super().draw()
        self.janela.draw_text(self.text, self.x+10, self.y+10, 20, (255,255,255))
    def write(self, char):
        if Text_field.ativo == self.id:
            if char.isalpha():
                self.text = self.text + char
    
class KeyboardController:
    def __init__(self) -> None:
        self.pressed = False
    def getKeyPressed(self, teclado):
        ret = ''
        rett = ''
        pressedL = False
        if teclado.key_pressed == 'A':
            ret = 'A'
            pressedL = True
        elif teclado.key_pressed == 'b':
            ret = 'b'
            pressedL = True
        if not self.pressed:
            rett = ret
        if pressedL:
            self.pressed = True
        else:
            self.pressed = False
        return rett
    



# teste.py

from classes import *
from PPlay.sprite import *
from BETONEIRA import*
janela = Window(1280, 720)
while True:
    login(janela)
    janela.set_background_color([35,35,35])
    janela.draw_vline(200, 0, 720)
    janela.draw_hline(0, 70, 200)
    janela.update()