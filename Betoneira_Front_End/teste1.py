# chamador.py
import requests
'''import subprocess

subprocess.run(['python', 'teste2.py', "a", "b"])'''

login = "nome"
senha = "senha"
params = {'login': login, 'senha': senha}
print(requests.get("http://localhost:8080/conta/nome", params=params))

