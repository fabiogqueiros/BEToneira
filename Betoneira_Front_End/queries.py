from random import randint
import requests

#
# QUANDO EU DIGO EMAIL, PROVAVELMENTE É O USERNAME, EU SÓ NÃO TROQUEI AINDA
#

def autentica(login, senha):
    params = {'nome': login, 'senha': senha}
    return "true" in str(requests.get("http://localhost:8080/conta/nome", params=params).content)

def cadastra(email, username, senha, confirmação):  #  envio os parâmetros e quero receber se o cadastro foi bem sucedido ou não (retorno: Bool)
    return True

def solicitarRecuperação(email):  # te envio o email e não quero receber nada, mas o código tem que ser gerado e "mandado" pro email da pessoa
    pass

def confirmarEmail(codigo, email):  # envio o código que o usuario escreveu e espero receber se esse foi o código enviado mesmo ou não (retorno: Bool)
    return True

def escolherNovaSenha(senha, email):  # envio a nova senha, que deverá ser cadastrada como a senha do usuario do email em questão
    pass

def geraPerfil(email):                             # envio o email e quero receber uma string formatada do perfil dele, com todas as informações e tal (retorno: String)
    print("\n<<<Aqui ficaria o perfil>>>\n")

def alteraUsername(email, novo):   # envio o novo username, que deve ser atualizado na base de dados.
    pass

def verificaSenha(email, antiga):  # envio o que o usuario digitou como senha antiga, e quero receber se esta é de fato a senha atual dele (retorno: Bool)  
    return True  # a checar se vai ser assim mesmo

def alteraSenha(email, novo):  # envio a senha nova, que deve ser alterada na base de dados
    pass

def fazerSaque(valor, senha, banco, conta, email):  # envio as informações e quero receber se o saque foi bem sucedido ou não
    return True

def getChave(email, valor):  # -- a checar se vai ser assim mesmo -- 
    return "PIXDOFABIO"

def geraExtrato(email, filtros):  # envio filtros e quero receber uma string formatada do extrato, ou então uma lista das entradas do extrato para futura formatação (retorno: String ou [String])
    print("\n<<<Aqui ficaria o extrato>>>\n") # ainda vou botar mais detalhes sobre os filtros, tanto pra essa função quanto pras 2 abaixo.

def geraHistorico(email, filtros):  # envio filtros e quero receber uma string formatada do histórico, ou então uma lista das entradas do histórico para futura formatação (retorno: String ou [String])
    print("\n<<<Aqui ficaria o histórico>>>\n")

def geraRanking(opt):  # envio o jogo e quero receber uma string formatada do ranking, ou então uma lista das entradas do ranking para futura formatação (retorno: String ou [String])
    print("\n<<<Aqui ficaria o ranking>>>\n")

def getOdd(param, tipo):  # envio um parâmetro e um tipo e quero saber a odd para essa operação: (retorno: Float)
    '''
    tipo = "cor", param = número de 1 a 3, representando a cor (vermelho, verde e branco, nessa ordem)
    tipo = "numero", param = lista de números de 1 a 9
    tipo = "loteria", param = ainda não sei. ainda vou fazer do jeito que fábio falou.
    
    os dois primeiros tipos são da roleta
    '''
    return 1.85

def getEstadoLoteria(email):  # quero receber em qual estado a loteria está para este usuário: 1 - ainda não apostou, 2 - já apostou e está aguardando resultado, 3 - já apostou e já saiu o resultado (retorno: Int)
    return randint(1, 3)

def getNumerosValidos():  # quero receber quais são os números válidos da loteria no seguinte formato: uma lista com o primeiro e o último número válidos. (retorno: [int, int])
    return [1, 30]

def iniciarLoteria(email, quantia, numeros):  # iniciar a roleta para esse usuario, com essa quantia a apostar e com esses numeros. ainda não refiz a loteria, mas provavelmete a variavel "numeros" será uma lista com 1 ou 2 inteiros.
    pass

def getLoteriaInfo():  # quero receber quantos usuários já apostaram na loteria atual, e quantos minutos faltam para o resultado. (retorno: [int, int])
    return [8000, 4]

def getLoteriaResultados(email):  # quero receber os números sorteados e quanto o usuário ganhou nessa aposta. de novo, por questão da mudança na loteria, ainda não está assim, mas o retorno deve ser (retorno: [int, int, int]), com os dois primeiros sendo os números sorteados e o último sendo o quanto o usuário ganhou.
    return [24, 0]

def quantiaValida(quantia, email):  # envio um valor e um email, e quero saber se o saldo do usuario é suficiente para apostar esse valor (retorno: Bool)
    return True