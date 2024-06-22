from aviao import aviao
from queries import *
from aux_functions import *

def alterarSenha():
    global email
    while True:
        antiga = input("Senha Antiga: ")
        aut = verificaSenha(email, antiga)
        if aut:
            nova = input("Nova Senha: ")
            alteraSenha(email, nova)
            break
        else:
            print("Senha incorreta!")
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                break

def editarPerfil():
    global email
    while True:
        opt = getInput(["Alterar Username", "Alterar Nickname", "Alterar Senha", "Voltar"])
        if opt == 1:
            novo = input("Novo Username: ")  #é possível fazer mais tratamento aqui
            alteraUsername(email, novo)
        elif opt == 2:
            novo = input("Novo Nickname: ")
            alteraNickname(email, novo)
        elif opt == 3:
            alterarSenha()
        else:
            break

def perfil():
    global email
    while True:
        geraPerfil(email)
        opt = getInput(["Editar Perfil", "Voltar"])
        if opt == 1:
            editarPerfil()
        else:
            break

def loteria():
    pass

def aviaoSetup():
    quantia = getQuantia()
    opt = getInput(["Confirmar e Iniciar", "Cancelar e voltar"])
    if opt == 1:
        aviao(quantia)

def roleta():
    pass

def jogar():
    while True:
        opt = getInput(["Loteria", "Avião", "Roleta", "Voltar"])
        if opt == 1:
            loteria()
        elif opt == 2:
            aviaoSetup()
        elif opt == 3:
            roleta()
        else:
            break

def saque():
    global email
    while True:
        valor = getValor()
        senha = input("Senha: ")
        banco = input("Banco: ")
        conta = input("Conta: ")
        ret = fazerSaque(valor, senha, banco, conta, email)
        if ret:
            print("Saque realizado com sucesso!")
            break
        else:
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                break

def deposito():
    global email
    valor = getValor()
    chave = getChave(email, valor)
    print(f"Faça um PIX para a chave {chave} e consulte o seu extrato")

def transacaoBancaria():
    while True:
        opt = getInput(["Saque", "Depósito", "Voltar"])
        if opt == 1:
            saque()
            break
        elif opt == 2:
            deposito()
            break
        else:
            break

def historico():
    while True:
        filtros = barraDeFiltro(["Loteria", "Avião", "Roleta"])
        geraHistorico(email, filtros)
        opt = getInput(["Aplicar novos filtros", "Voltar"])
        if opt == 2:
            break

def extrato():
    while True:
        filtros = barraDeFiltro(["Saque", "Depósito"])
        geraExtrato(email, filtros)
        opt = getInput(["Aplicar novos filtros", "Voltar"])
        if opt == 2:
            break

def ranking():
    while True:
        opt = getInput(["Loteria", "Avião", "Roleta", "Voltar"])
        if opt == 4:
            break
        else:
            geraRanking(opt)

def BEM_VINDO_À_BETONEIRA():
    global email
    while True:
        opt = getInput(["Perfil", "Jogar", "Saque/Depósito", "Histórico", "Extrato", "Ranking", "Logout"])
        if opt == 1:
            perfil()
        elif opt == 2:
            jogar()
        elif opt == 3:
            transacaoBancaria()
        elif opt == 4:
            historico()
        elif opt == 5:
            extrato()
        elif opt == 6:
            ranking()
        elif opt == 7:
            break

def login():
    while True:
        login = input("Login: ")
        senha = input("Senha: ")
        if autentica(login, senha):
            global email
            email = login
            BEM_VINDO_À_BETONEIRA()
            break
        else:
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                break

def cadastrar():
    while True:
        login = input("Login: ")
        senha = input("Senha: ")
        confirmação = input("Senha Novamente: ")
        if cadastra(login, senha, confirmação):
            print("Cadastrado com sucesso!")
            break
        else:
            print("Ops! Algo deu errado.")
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                break

def recuperarSenha():
    global email
    cod = enviarCodigo(email)   # ver melhor quem verifica o cod
    while True:
        codigo = input("Digite o código enviado para o seu email: ")
        if codigo == cod:
            nova = input("Digite sua nova senha: ")
            print("Senha definida com sucesso!")
            break
        else:
            print("Ops! Algo deu errado.")
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                break


while True:
    opt = getInput(["Login", "Cadastrar", "Recuperar Senha", "Sair"])
    if opt == 1:
        login()
    elif opt == 2:
        cadastrar()
    elif opt == 3:
        pass
        recuperarSenha()
    else:
        break