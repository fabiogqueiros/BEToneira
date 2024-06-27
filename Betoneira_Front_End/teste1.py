# chamador.py
import requests
'''import subprocess

subprocess.run(['python', 'teste2.py', "a", "b"])'''

login = "Leo"
senha = "senha"
params = {'nome': login, 'senha': senha}
print("true" in str(requests.get("http://localhost:8080/conta/nome", params=params).content))

