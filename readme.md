Sobre o Projeto:

    Este projeto é a resolução do desafio proposto pela Proway em parceria com a Pública, como processo seletivo para o programa de capacitação da Proway (OUT 2020).
    O problema soi solucionado utilizando linguagem Java 8.
    Softwares utilizados: Git; NetBeans 8.2.

Para rodar o projeto:
    
    1 - Abra o terminal do Git em sua máquina no local que deseja fazer download do projeto, e rode o comando
    git clone https://github.com/giulio7771/desafio_publica_proway.git

    2 - Abra o projeto no NetBeans: Arquivo -> Abrir Projeto; navegue até o local de download do projeto, e de dois cliques em cima do ícone de copo de café do Java.

    3 - Verifique se o projeto está definido como projeto principal, caso não esteja: Executar -> Definir Projeto Principal; e selecione este projeto.

    4 - Pronto para rodar

Documentação:
    
    O projeto está se baseando na arquitetura MVC, porém é uma aplicação desktop, e não está sendo utilizado banco de dados.
    
    Os teste unitários se encontram em Pacotes de Testes/<pacote default>. Existem duas classes de teste: MatchTest e SeassonTest. Para executá-los basta abrir o respectivo arquivo de testes, botão direito > Testar Arquivo, ou usar o atalho: Ctrl F6.

    A interface gráfica foi feita usando o JFrame do Java Swing, que está no pacote view. A interface se comunica apenas com SeassonController. 
    As duas requisições que a interface faz são: addMatch, para adicionar uma nova partida de Marta, e getHistoryReport, para obter o relatório que é impresso na tela de Histórico.

    No pacote model exitem 3 classes: Match, que representa uma partida; Round, que representa uma rodada do campeonato; e Seasson, que representa uma temporada do campeonato.
    A função de Round é salvar o estado atual da rodada cadastrada, com intuito de gerar o histórico.
    Match possuí apenas o pontuação de Marta, porém poderia ser modificada para possuir demais atributos de uma partida real.
    Seasson é faz relação de 1 para n com Match e Round, controlando os dados da rodada conforme especificação no método addMatch, que verifica e atualiza os recordes, adiciona uma partida nova (apenas para controle nesse problema reduzido proposto), e uma rodada nova.