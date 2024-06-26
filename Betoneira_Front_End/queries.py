from random import randint

def autentica(login, senha):
    return True

def cadastra(email, username, nickname, senha, confirmação):
    return True

def enviarCodigo(email):
    return '40028922'

def geraPerfil(email):
    print("\n<<<Aqui ficaria o perfil>>>\n")

def alteraUsername(email, novo):
    pass

def alteraNickname(email, novo):
    pass

def verificaSenha(email, antiga):
    return True

def alteraSenha(email, novo):
    pass

def fazerSaque(valor, senha, banco, conta, email):
    return True

def getChave(email, valor):
    return "PIXDOFABIO"

def geraExtrato(email, filtros):
    print("\n<<<Aqui ficaria o extrato>>>\n")

def geraHistorico(email, filtros):
    print("\n<<<Aqui ficaria o histórico>>>\n")

def geraRanking(opt):
    print("\n<<<Aqui ficaria o ranking>>>\n")

def getQuantia():
    return 200

def getOdd(param, tipo):
    return 1.85

def getEstadoLoteria(email):
    return randint(1, 3)

def iniciarLoteria(email, quantia, numeros):
    pass

def getLoteriaInfo():
    return [8000, 4]

def getLoteriaResultados(email):
    return [24, 0]