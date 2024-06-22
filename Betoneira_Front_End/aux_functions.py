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
        filtros = getFiltros()
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

def getFiltros():  #necessita de mais tratamento
    ipt = input("Quais filtros deseja aplicar? (Números separados por espaços, exemplo: '1 3'. Apertar Enter para nenhum filtro) ")
    ret = ipt.split()
    for i in range (len(ret)):
        ret[i] = int(ret[i])
    return ret

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