## Getting Started

Trabalho proposto em sala de aula pelo professor Jason com o objetivo de análisar os conhecimentos dos aluno.

# OBJETIVO DO PROJETO
O objetivo do projeto era construir um pequeno jogo de batalhas em formato de RPG que a cada monstro derrotado passaria para a próxima fase aprimorando suas skills básicas e ganhando algumas poções que ajudariam o jogador nas fases seguintes até derrotar o Boss final que seria o Rei demônio. A batalhas são compostas por uma interface gráfica que te dá o direito de fazer 4 opções. A cada boss derrotado o jogo mostra a opção de salvar sendo possível salvar o nível e as habilidades em que o jogador se encontra.  

# COMO AS CLASSES SE INTERLIGAM

Ao todo o projeto contém 30 classes mais os arquivos.txt.
1. Coleção:  Com relação a coleções foi utilizado classes de controle como por exemplo “HabilityController” onde tinha o objetivo de carregar todos os dados necessários usando ArrayLists.
2. Composições: Utilizamos a composição na classe Player onde chamava as classes “hability” e “armor” para ter habilidades e adicionar armadura ao player, isso também foi aplicado na classe monstro nos dois bosses do nosso jogo utilizando somente a classe “hability”, em relação a agregação a classe floor pode existir sem o Player, porém o Player não pode existir sem o floor.
3. Herança: Herança foi aplicada com a classe monstro onde há subclasses dela que seriam os próprios monstros, 
4. Classe abstrata: o monstro ele é uma classe abstrata onde não pode ser instanciado no jogo.
5. Interface: Utilizamos a interface para gerar o método de ataque.
6. Polimorfismo: Foi utilizado polimorfismo com a classe monstro para não fosse necessário fazer battles diferentes.

# RODAR O JOGO

Para rodar o jogo basta somente ter todos os arquivos presentes nos repositórios e rodar a main.

# USO DO CHATGPT

Uso do chat:
Foi utilizado o chatgpt cara criar o printSlowly com o objetivo de gerar caracteres de forma mais lenta. Também foi usado para criar o nome das habilidades e armaduras. Foi utilizado também para gerar sugestões do código e tirar algumas.

# REFERENCIAS E RECURSOS
Referencias e recursos: https://www.digitalocean.com/community/tutorials/java-clone-object-cloning-java
