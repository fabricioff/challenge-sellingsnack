# Selling Sancks

### URL para lista de lanches
http://localhost:8080/sellingsnack-ws/snack

### URL para detalhes do lanche
http://localhost:8080/sellingsnack-ws/snack/find/{nome}

### URL para lista de promoções
http://localhost:8080/sellingsnack-ws/sale

### URL para lista de ingredientes
http://localhost:8080/sellingsnack-ws/ingredient

## Módulos
```
 /sellingsnack-angular
 /sellingsnack-model
 /sellingsnack-ws
 /tools
```

* Os módulos "*/sellingsnack-model*" e "*/sellingsnack-ws*" estão sendo gerenciados pelo Maven e para gerar seus artefatos é necessário executar o comando "**mvn clean install**".

* Já o módulo "*/sellingsnack-angular*" é um projeto desenvolvido em Angular8 e Node10 e seu artefato pode ser gerado usando o comando "**ng serve**", porém, talvez seja necessário executar o comando "**npm install**" antes, para atualizar ou gerar os módulos do Node.

## Funcionamento
1. Ao executar o comando do Maven para gerar o artefato, será feito um deploy deste artefato no servidor de aplicação(Tomcat) que se encontra na pasta "**/tools**";
2. É necessário executar o servidor de aplicação(Tomcat), executando o seguinte comando: "**\tools\dev\apache-tomcat-9.0.24\bin\startup.bat**";
3. Com o servidor rodando, já é possível abrir o navegador e carregar a seguinte URL: "**http://localhost:4200/**";
4. Serão listados os lanches disponíveis, onde ao se clicar em algum lanche, será exibido sua lista de ingredientes, se pertence a alguma promoção e o calculo do valor final do lanche considerando os descontos promocionais. 
