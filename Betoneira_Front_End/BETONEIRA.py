from queries import *
from aux_functions import *
import subprocess

email = ''

def alterarSenha():
    global email
    while True:
        antiga = input("Senha Antiga: ")
        nova = input("Nova Senha: ")
        deuCerto = alteraSenha(email, antiga, nova)
        if deuCerto:
            print("Senha alterada com sucesso!")
            break
        else:
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                break
    
def excluirConta():
    global email
    while True:
        senha = input("Insira sua senha: ")
        print("Tem certeza que deseja excluir a conta?")
        opt = getInput(["Sim", "Não"]) 
        if opt == 1:
            deuCerto = excluiConta(email, senha)
            if deuCerto:
                print("Conta excluída com sucesso!")
                exit()
            else:
                print("Senha errada.")
                opt = getInput(["Tentar de novo", "Voltar"])
                if opt == 2:
                    break
        else:
            break

def editarPerfil():
    global email
    while True:
        opt = getInput(["Alterar Username", "Alterar Senha", "Excluir Conta", "Voltar"])
        if opt == 1:
            novo = input("Novo Username: ")
            check = alteraUsername(email, novo)
            if check:
                print("Username atualizado com sucesso!")
            else:
                print("Esse Username já está sendo usado.")
        elif opt == 2:
            alterarSenha()
        elif opt == 3:
            excluirConta()
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

def getNumerosLoteria(ini, fim, qtd):
    n1 = n2 = -1
    while True:
        ipt = input(f"Digite um número entre {ini} e {fim}: ")
        try:
            if ini < int(ipt) < fim:
                n1 = int(ipt)
                break
            else:
                print("Algo deu errado. Tente novamente.")
        except:
            print("Algo deu errado. Tente novamente.")
    while qtd == 2:
        ipt = input(f"Digite um número entre {ini} e {fim} diferente de {n1}: ")
        try:
            if ini < int(ipt) < fim and n1 != int(ipt):
                n2 = int(ipt)
                break
            else:
                print("Algo deu errado. Tente novamente.")
        except:
            print("Algo deu errado. Tente novamente.")
    if qtd == 1:
        return (n1)
    else:
        return (n1, n2)

def loteria():
    global email
    while True:
        estado = getEstadoLoteria(email)
        if estado == 1:
            numValid = getNumerosValidos()
            print("Quantos números quer apostar?")
            qtd = getInput(["1", "2"])
            numeros = getNumerosLoteria(numValid[0], numValid[1], qtd)
            quantia = getQuantia(email)
            odd = getOdd(numeros, 'loteria')
            print(f"ODD: {odd}")
            opt = getInput(["Confirmar e Iniciar", "Cancelar e voltar"])
            if opt == 1:
                estado = 2
                iniciarLoteria(email, quantia, numeros)
            else:
                break
        if estado == 2:
            info = getLoteriaInfo()
            print(f"{info[0]} pessoas apostaram")
            print(f"Restam {info[1]} minutos até o resultado")
            opt = getInput(["Sair"])
            break
        elif estado == 3:
            resultados = getLoteriaResultados(email)
            print(f"Os números sorteados foram {resultados[0]} e {resultados[1]}")
            print(f"Você ganhou V${resultados[2]}")
            opt = getInput(["Apostar Novamente", "Sair"])
            if opt == 2:
                break

def aviaoSetup():
    global email
    while True:
        quantia = getQuantia(email)
        opt = getInput(["Confirmar e Iniciar", "Cancelar e voltar"])
        if opt == 1:
            cont = subprocess.run(['python', 'aviao.py', f"{quantia}", f"{email}"]).returncode
            if cont == 1:
                break
                

def cor(quantia):
    global email
    opt = getInput(["Vermelho", "Verde", "Branco"])
    odd = getOdd(opt, 'cor')
    print(f"ODD: {odd}")
    opt2 = getInput(["Confirmar e Iniciar", "Cancelar e voltar"])
    if opt2 == 1:
        return subprocess.run(['python', 'roleta.py', "cor", f"{opt}", f"{email}", f"{quantia}", f"{odd}"])
    return 1

def numero(quantia):
    global email
    opt = getNumeros(1, 9)
    odd = getOdd(opt, 'numero')
    print(f"ODD: {odd}")
    opt2 = getInput(["Confirmar e Iniciar", "Cancelar e voltar"])
    if opt2 == 1:
        return subprocess.run(['python', 'roleta.py', "num", f"{opt}", f"{email}", f"{quantia}", f"{odd}"])
    return 1

def roletaSetup():
    global email
    while True:
        quantia = getQuantia(email)
        opt = getInput(["Cor", "Número"])
        if opt == 1:
            cont = cor(quantia)
            try:
                cont = cont.returncode
            except:
                pass
        else:
            cont = numero(quantia)
            try:
                cont = cont.returncode
            except:
                pass
        if cont == 1:
            break

def jogar():
    while True:
        opt = getInput(["Loteria", "Avião", "Roleta", "Voltar"])
        if opt == 1:
            loteria()
        elif opt == 2:
            aviaoSetup()
        elif opt == 3:
            roletaSetup()
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
        email = input("Email: ")
        username = input("Username: ")
        senha = input("Senha: ")
        confirmação = input("Senha Novamente: ")
        if cadastra(email, username, senha, confirmação):
            print("Cadastrado com sucesso!")
            break
        else:
            print("Ops! Algo deu errado.")
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                break

def recuperarSenha():
    while True:
        print("Por onde deseja receber o código?")
        opt = getInput(["Email", "SMS", "Correios"])
        txt = ''
        if opt == 1:
            txt = "seu email"
        elif opt == 2:
            txt = "seu número de telefone"
        elif opt == 3:
            txt = "seu endereço"
        info = input(f"Digite o {txt}: ")
        deuCerto = solicitarRecuperação(opt, info)
        if deuCerto:
            break
        else:
            print("Ops! Algo deu errado.")
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                return
    while True:
        codigo = input("Digite o código enviado para o seu email: ")
        if confirmarEmail(codigo, email):
            nova = input("Digite sua nova senha: ")
            escolherNovaSenha(nova, email)
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