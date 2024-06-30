from random import randint
import requests
#from aux_functions import isValidDate

#
# QUANDO EU DIGO EMAIL, PROVAVELMENTE É O USERNAME, EU SÓ NÃO TROQUEI AINDA
#


#  -------------------- login, cadastro, rec senha -------------------------------
# tá faltando pedir as opções de recuperação ainda

def autentica(login, senha):
    params = {'nome': login, 'senha': senha}
    return "true" in str(requests.get("http://localhost:8080/conta/nome", params=params).content)

def cadastra(email, username, senha, confirmação):  #  envio os parâmetros e quero receber se o cadastro foi bem sucedido ou não (retorno: Bool)
    return True

def solicitarRecuperação(meio, info):  # envio o meio (int: 1 - email, 2 - sms, 3 - correios) e a informação (o email, o numero de telefone ou o endereço) e espero que a informação seja checada pra ver se faz sentido (é uma string crua) e, se fizer, que seja "enviado" o código por esse meio. De retorno, espero receber se deu tudo certo ou não (retorno: Bool)
    return True

def confirmarEmail(codigo, email):  # envio o código que o usuario escreveu e espero receber se esse foi o código enviado mesmo ou não (retorno: Bool)
    return True

def escolherNovaSenha(senha, email):  # envio a nova senha, que deverá ser cadastrada como a senha do usuario do email em questão
    pass

# --------------------------- Perfil --------------------------------

def geraPerfil(email):                             # envio o email e quero receber uma string formatada do perfil dele, com todas as informações e tal (retorno: String)
    print("\n<<<Aqui ficaria o perfil>>>\n")

def alteraUsername(email, novo):   # envio o novo username, que deve ser atualizado na base de dados.
    pass

def alteraSenha(email, antigo, novo):  # envio a senha antiga e a nova. se a antiga for igual à senha atual, a senha do usuario deve ser alterada para a nova. o retorno esperado é se deu certo (a antiga estava certa) ou não (retorno: Bool)
    return True

def excluiConta(email, senha):  # checa se a senha está correta e, se sim, exclui a conta. (retorno: Bool)
    return True

# ----------------------------Saque e Depósito----------------------------

def fazerSaque(valor, senha, banco, conta, email):  # envio as informações e quero receber se o saque foi bem sucedido ou não
    body = {"tipo": "Saque", "quantia": valor}
    a = requests.post("http://localhost:8080/transacao/", data=body)
    return True

def getChave(email, valor):  # não sei se vai ficar assim mesmo, mas eu envio um valor e espero receber uma chave pix pra fazer o depósito (retorno: String)
    body = {"tipo": "Saque", "quantia": valor, "modo": "Esperando Pagamento"}
    a = requests.post("http://localhost:8080/transacao/", data=body)
    return "PIXDOFABIO"

# -----------------------------Consultas------------------------------

def geraExtrato(email, filtros):  # envio filtros (tanto "filtros" quando "datas", que eu separei por diferença de tipo) e quero receber uma string formatada do extrato, ou então uma lista das entradas do extrato para futura formatação (retorno: String ou [String])
    datas = []
    if isValidDate(filtros[-1]):
        datas = [filtros[-2], filtros[-1]]
        filtros = filtros[0:-2]

    '''
    filtros pode conter de 0 a 2 números:
    1 - Saque
    2 - Depósito
    datas pode conter 0 ou 2 datas (inicio e fim)
    as datas são string
    '''

    print("\n<<<Aqui ficaria o extrato>>>\n")

def geraHistorico(email, filtros):  # envio filtros (tanto "filtros" quando "datas", que eu separei por diferença de tipo) e quero receber uma string formatada do histórico, ou então uma lista das entradas do histórico para futura formatação (retorno: String ou [String])
    datas = []
    if isValidDate(filtros[-1]):
        datas = [filtros[-2], filtros[-1]]
        filtros = filtros[0:-2]

    '''
    filtros pode conter de 0 a 3 números:
    1 - Loteria
    2 - Avião
    3 - Roleta
    datas pode conter 0 ou 2 datas (inicio e fim)
    as datas são string
    '''

    print("\n<<<Aqui ficaria o histórico>>>\n")

def geraRanking(opt):  # envio o jogo e quero receber uma string formatada do ranking, ou então uma lista das entradas do ranking para futura formatação (retorno: String ou [String])
    print("\n<<<Aqui ficaria o ranking>>>\n")

# ---------------------------Jogos--------------------------------

def getOdd(param, tipo):  # envio um parâmetro e um tipo e quero saber a odd para essa operação: (retorno: Float)
    '''
    tipo = "cor", param = número de 1 a 3, representando a cor (vermelho, verde e branco, nessa ordem)
    tipo = "numero", param = lista de números de 1 a 9
    tipo = "loteria", param = tupla com 1 ou 2 inteiros
    
    os dois primeiros tipos são da roleta
    '''
    return 1.85

def getEstadoLoteria(email):  # quero receber em qual estado a loteria está para este usuário: 1 - ainda não apostou, 2 - já apostou e está aguardando resultado, 3 - já apostou e já saiu o resultado (retorno: Int)
    return randint(1, 3)

def getNumerosValidos():  # quero receber quais são os números válidos da loteria no seguinte formato: uma lista com o primeiro e o último número válidos. (retorno: [int, int])
    return [1, 30]

def iniciarLoteria(email, quantia, numeros):  # iniciar a roleta para esse usuario, com essa quantia a apostar e com esses numeros. a variável "numeros" é uma tupla com 1 ou 2 inteiros.
    pass

def getLoteriaInfo():  # quero receber quantos usuários já apostaram na loteria atual, e quantos minutos faltam para o resultado. (retorno: [int, int])
    return [8000, 4]

def getLoteriaResultados(email):  # quero receber os números sorteados e quanto o usuário ganhou nessa aposta. Ou seja, o retorno deve ser [numero 1, numero 2, valor ganho] (retorno: [int, int, float]) (caso não dê pra retornar assim por causa do Java, retorna [float, float, float])
    return [24, 27, 0]

def quantiaValida(quantia, email):  # envio um valor e um email, e quero saber se o saldo do usuario é suficiente para apostar esse valor (retorno: Bool)
    return True

def getResultadoRoleta(tipo, opt, email, quantia):  # contém toda a parte da roleta. O back deve receber os dados, criar a aposta, gerar um número de 1 a 9 e retorná-lo. Com os dados da aposta e o resultado, o back já deve fazer toda a lógica de verificar se o usuario ganhou ou perdeu e concretizar os resultados na conta bancária. Porém, o retorno é apenas o resultado da roleta, de 1 a 9. (retorno: Int)
    '''
    tipo: "cor" ou "numero"
    opt: número de 1 a 3 no caso das cores
            ou
        lista com números de 1 a 9 no caso dos números (mesma regra do getOdd)
    '''
    return randint(1, 9)

def começar(email, quantia):  #inicia o avião com essa quantia
    pass

def crashou():  #lógica fake. aqui estaria a requisição. espero receber se o avião crashou ou não (retorno: Bool)
    l = [False, False, False, False, False, False, False, False, False, False, False, False, True, False]
    n = len(l)
    i = randint(0, n-1)
    return l[i]

def pararReq(email):  # para o aviãozinho, se ainda não tiver crashado, e retorna o multiplicador real no momento da parada (retorno: Float)
    return 1.24

#---------------------------------------------------------------------------------------------------------------------------------------------------------
#ignora isso
def isValidDate(data):
    data = data.split('/')
    if len(data) == 3:
        if len(data[0]) != 2:
            return False
        if len(data[1]) != 2:
            return False
        if len(data[2]) != 4:
            return False
        c = 0
        for v in data:
            try:
                int(v)
                c += 1
            except ValueError:
                pass
        if c == 3:
            return True
        else: 
            return False
    else:
        return False