# Java e Refatoração: Melhorando Códigos Com Boas Práticas

## Ambiente

Para subir a api, utilizar: `java -jar api.jar`, isso subirá um servidor Spring com a API.

## Sobre o desafio

Devemos partir do seguinte: ***SEU CÓDIGO É RUIM, TÃO RUIM QUE CHEIRA MAL***, até temos um nome para isso, *Code Smells*, nesse caso *BAD smells*. Quanto menos experiente, mais cheiro e menos se sente o cheiro. Afinal de contas, ninguém sente o cheiro do próprio chule, mesmo que pareça que tem um urubu morto no lugar do pé. A nossa aplicação inicial é o urubu, toda a logica dela está em uma unica classe.

Como eu estou iniciando, pode ser que eu só esteja indo dum urubu para um rato, ainda fede só que não tanto. Segundo a minha referência e o meu entendimento, uma classe muito grande se enquadra nos *Bloaters*, sendo um pouco mais especifico, temos uma *Large Class*.

>Vamos ao despenamento desse urubu.

## Extract Method

Aqui, como em várias outras partes da vida, vale a máxima dum *"grande filósofo"*: *vamos por partes*, ou a de minha alcunha *pena por pena*.

Dentro de um grupo chamado *Composing Methods* podemos encontrar um que muito nos agrada, o *Extract Method*, sem ler nada sobre, o que deveria ser feito? É isso.

Com isso, saimos duma classe com um monte de lógica para uma que chama os métodos que possuem a lógica de negócio, nosso código ainda fede, só que um pouco menos.

- [X] Primeiro Pena.

Não sei ao certo se o que vou falar entra nesse tópico também, creio que sim, seguirei como se fosse sim. Algo que aprendi a duras penas é que não devemos repetir muito código, na verdade devemos repedir nada, eu já tinha interiorizado isso e procurava formas de contornar. Até que um dia eu ouvi, ou li, ou vi, na Alura mesmo, o seguinte termo ***DRY Don’t Repeat Yourself***, aqui também não cabe um explicação, uma analise fria da expressão já vai dar uma boa ideia do que devemos fazer.

Tirando um pouco de código duplicado, temos a remoção de mais uma pena.

- [X] Segunda Pena.

## S.O.L.I.D

Devo dizer que sou noob com relação a isso, fiz um curso, na Alura também, sobre o tema, sei uma coisa ou outra, mas tenho que refletir um pouco mais, até que isso faça parte de mim. Com essa carta em jogo, vamos ver um pouco sobre o **S**, ***Single Responsibility Principle***, mantendo o modelo aqui criado, só de traduzir o principio vemos que é algo sobre *responsabilidade unica*. Tá, vamos olhar para o código. Tudo o que foi escrito até agora, esta dentro dum único arquivo, dentro duma única classe.

>Bem está tudo certo, né? A minha classes `Main` tem a única responsabilidadade de lidar com a aplicação inteira, vida que segue.

Para evitar que algumas topeira pensem assim, podemos dar um pouco mais de contexto para elas, afinal de contas, até o GPT precisa de contexto para não gerar respostas estupidas.

>Uma classe deve ter um, e somente um, motivo para mudar.

A partir daqui é só refletir o que essa máxima quer dizer. Ao meu ver, ela ajuda tanto quanto atrapalha, o que é "somente um motivo"? Eu me debato sobre isso até hoje, uma coisa é pegar um exemplo pronto na internet e dizer que entendeu, outra é fazer um do zero, somente você e Deus.

Então, evoluiremos nosso código criando classes que representem alguma funcionalidade, ou regra de negocio. Aparentemente os desenvolvedores tendem a chamar essas classes de *service*, ou utilizar um verbo com nome, essa observação é minha, e discuti comigo mesmo no carro a caminho de casa. Vamos ver se consigo explicar.

>No centro do nosso software temos a regra de negocio, aquilo cujo qual diz o que o nosso código faz. Todo padrão de design que usamos tenta isolar essa camada. Bem é nessa camada que as coisas acontecem, é ela que cria, utilizando das outras como suporte, por exemplo, ela utiliza a camada de infraestrutura para consutlar alguma coisa, e realizar algum operação. Creio ser por isso que nessa camada os nomes das classes tentem a ser um verbo, ou *Service*.

Posso tentar escrever isso um pouco melhor em algum outro momento, quem sabe quando resolver falar sobre Port and Adapter. Por hora o que importa é:

- [X] Terceira Pena.

Outra coisa que é legal ter, nossos objetos do mundo real devem ser bem representando dentro do código. Por exemplo, se eu tenho um Pet que possui nome, idade, raça, etc. é interessante criar um classe que o represente. E é esse o ponto que iremos tratar agora, criar os objetos do mundo real que fazem parte do nosso dominio. Essa é uma outra camada que podemos encontar em vários modelos de design de código. Um resumo é o que puz aqui, ela contém os objetos do mundo real.

- [X] Quarta Pena.

## Testes Automatizados

A ideia é sempre evoluir e melhorar a nós mesmos, ser anti-frágil, temos que ter a mesma ideia quanto ao nosso código. Ele deve estar sempre mudando, para melhor, e resistir a essas mudançar. É possível conseguir fazer isso com teste, se eles forem bem escritos nossa lógica pode resistir a qualquer alteração, nos dando confiança para melhorar a nós mesmos, aprendendo novas tecnicas de programação, e ao código, quando aplicarmos essas técnicas nele.

Para conseguirmos realizar os testes com sucesso e separa testes de unidade dos de integração, é preciso que nosso código tenha um certo padrão, principalmente no tocante às dependências. Já evoluimos estamos caminhando nessa estrada, continuaremos e iremos *"ao infinito e além"*.

O objetivo aqui não é explicar a fundo como funciona testes e tudo mais, só falar que no processo de refatoração os testes são importantes. E eles ajudam na refatoração, dando segurança.

Fez os testes no seu código? Então:

- [X] Quinta Pena.

## Padrões de projetos

Você não é o primeiro que está resolvendo esse problema, nunca será. Para ajudar em alguns pontos, temos alguns padrões de projetos que foram criados, eles resolvem a maioria de nossos problema. Por exemplo, a nossa classe `Main`, atualmente, está instânciando muitas outras classes, o que cria um certo acoplamento, acoplamento MAU. E temos uma cambada de `ifs` também, ifs MAUS. Vamos tentar nos livar deles.

Para tal, usaremos o padrão de projeto Command. Um resumo de nossa refêrencia:

>***O Command é um padrão de projeto comportamental que transforma um pedido em um objeto independente que contém toda a informação sobre o pedido. Essa transformação permite que você parametrize métodos com diferentes pedidos, atrase ou coloque a execução do pedido em uma fila, e suporte operações que não podem ser feitas.***

Com esse padrão iremos remover algumas dependências que estão na `Main` e passar para nossas classes `Command`. Isso nós ajuda a ter um pouco mais de controle sobre as instâncias das classes **services**.

- [X] Sexta Pena.

Nossa última pena, as tiradas no curso, fica a cargo do bando de ifs que tinhamos na `Main`. Com o **Java 17** da para usar um `switch` e resolver esse problema de forma mais elegante.

## Conclusão

Meu objetivo aqui não foi mostrar código e como tudo foi implementado. Para isso você tem o meu repositório e o curso da Alura. O que quero aqui é me testar, ir além, **PLUS ULTRA**. Pro hora, façam o curso da Alura.

Só quero descrever o que vi, e colocar algumas referências.

## Referências

- [REFACTORING GURU, Catálogo refatoração](https://refactoring.guru/pt-br/refactoring/catalog)
- [RAFAEL SOUZA, Não Se Repita (DRY Don’t Repeat Yourself)](https://medium.com/@rafaelsouzaim/n%C3%A3o-se-repita-dry-dont-repeat-yourself-40da33289bcf)
- [JOÃO ROBERTO PAIXÃO, O que é SOLID: O guia completo para você entender os 5 princípios da POO](https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530)
- [REFACTORING GURU, Command](https://refactoring.guru/pt-br/design-patterns/command)
- [ALURA - Java e refatoração: melhorando códigos com boas práticas](https://www.alura.com.br/conteudo/java-refatoracao-melhorando-codigos-boas-praticas)
- [LUCAS PALHARES BARBOSA - Introdução aos conceitos de refatoração](https://desenvolvimento.shift.com.br/introdu%C3%A7%C3%A3o-aos-conceitos-de-refatora%C3%A7%C3%A3o-61027c8127e4)
