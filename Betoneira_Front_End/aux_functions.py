from queries import quantiaValida

def getInput(options):
    n = len(options)
    opt = -1
    print('')
    while not (1 <= opt <= n):
        for i, v in enumerate(options):
            print(f"({i+1}) {v}")
        opt = int(input("\nEscolha uma opção: "))
        print('')
        if not (1 <= opt <= n):
            print("Opção Inválida. Tente novamente.")
    return opt

def getValor():
    valor = "valor errado"
    while not is2fp(valor):
        valor = input("Valor (XX.XX): ")
    return float(valor)

def is2fp(valor):
    if len(valor) > 2:
        if valor[-3] == '.':
            try:
                float(valor)
                return True
            except ValueError:
                return False
        else:
            return False
    else:
        return False
    
def barraDeFiltro(options):
    n = len(options)
    filtros = [-1]
    valid = False
    while not valid:
        c = 0
        for i, v in enumerate(options):
            print(f"({i+1}) {v}")
        filtros = getFiltros(1, n)
        for v in filtros:
            if 1 <= v <= n:
                c += 1
        if c == len(filtros):
            valid = True
        else:
            opt = getInput(["Tentar novamente", "Prosseguir sem filtros"])
            if opt == 2:
                filtros = []
                valid = True
    print("Deseja aplicar filtro de data?")
    opt = getInput(["Sim", "Não"])
    if opt == 1:
        getDatas(filtros)
    return filtros

def getFiltros(ini, fim):
    print("Quais filtros deseja aplicar? (Apertar apenas Enter para nenhum filtro) ")
    return getNumeros(ini, fim)

def getDatas(filtros):
    dataInicio = getData("início")
    dataFim = getData("fim")
    filtros.append(dataInicio)
    filtros.append(dataFim)

def getData(tipo):
    while True:
        data = input(f"Insira a data de {tipo} (DD/MM/YYYY): ")
        if isValidDate(data):
            return data
        else:
            print("Data inválida. Tente novamente.")
        
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
    
def getNumeros(ini, fim):
    while True:
        rsp = input(f"Selecione Números de {ini} a {fim} (com espaço entre os números, exemplo: 2 6 7): ")
        try:
            ret = rsp.split()
            for i in range (len(ret)):
                ret[i] = int(ret[i])
                if ret[i]>fim or ret[i]<ini:
                    raise Exception("Número fora da faixa especificada")
            return ret
        except:
            print("Formatação ou dados errados. Tente novamente.")

def getQuantia(email):
    while True:
        ipt = input("Quanto gostaria de apostar? V$")
        valid = True
        try:
            ipt = float(ipt)
        except:
            valid = False
        req = quantiaValida(ipt, email)
        if req and valid:
            return ipt
        else:
            print("Quantia selecionada é maior que o saldo da conta.")
            opt = getInput(["Tentar de novo", "Voltar"])
            if opt == 2:
                return 0
