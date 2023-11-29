# gesthor
Gesthor - Gestão de Contratos Centralizados

O Gesthor é uma webapp para gestão centralizada de contratos. Para maior informação, verifique o projeto e os cards de evolução do sistema.

# Como executar

## via docker
- para build da imagem.: *docker build -f ./Dockerfile . -t <alguma tag qualquer>*
- para rodar a partir da imagem criada .: *docker run --name <nome do container> -p 8080:8180 -d <imagem criada anteriormente>*

- Exemplo
```
   docker build -f ./Dockerfile . -t devbearded/gesthor:1.0
   docker run --name gesthor -p 8080:8180 -d devbearded/gesthor:1.0
```
