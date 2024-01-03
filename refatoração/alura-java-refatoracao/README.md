# Java e Refatoração: Melhorando Códigos Com Boas Práticas

## Ambiente

Para subir a api, utilizar: `java -jar api.jar`, isso subirá um servidor Spring com a API.

## Sobre o desafio

Devemos partir do seguinte: ***SEU CÓDIGO É RUIM, TÃO RUIM QUE CHEIRA MAL***, até temos um nome para isso, *Code Smells*, nesse caso *BAD smells*. Quanto menos experiente, mais cheiro e menos se sente o cheiro. Afinal de contas, ninguém sente o cheiro do próprio chule, mesmo que pareça que tem um urubu morto no lugar do pé. A nossa aplicação inicial é o urubu, toda a logica dela está em uma unica classe.

Como eu estou iniciando, pode ser que eu só esteja indo dum urubu para um rato, ainda fede só que não tanto. Segundo a minha referência e o meu entendimento, uma classe muito grande se enquadra nos *Bloaters*, sendo um pouco mais especifico, temos uma *Large Class*.

Vamos os despenamento desse urubu.

## Extract Method

Aqui, como em várias outras partes da vida, vale a máxima dum *"grande filósofo"* *vamos por partes*, ou a alcunha *pena por pena*.

Dentro de um grupo chamado *Composing Methods* podemos encontrar um que muito nos agrada, o *Extract Method*, sem ler nada sobre, o que deveria ser feito? É isso.

Com isso, saimos duma classe com um monte de lógica para uma que chama os métodos que possuem a lógica de negócio, nosso código ainda fede, só que um pouco menos.

- [X] Primeiro Pena.

Não sei ao certo se o que vou falar entra nesse tópico também, creio que sim, seguirei como se fosse sim. Algo que aprendi a duras penas é que não devemos repetir muito código, na verdade devemos repedir nada, eu já tinha interiorizado isso e procurava formas de contornar. Até que um dia eu ouvi, ou li, ou vi, na Alura mesmo, o seguinte termo ***DRY Don’t Repeat Yourself***, aqui também não cabe um explicação, uma analise fria da expressão já vai dar uma boa ideia do que devemos fazer.

Tirando um pouco de código duplicado, temos a remoção de mais uma pena.

- [X] Segunda Pena.

## S.O.L.I.D

Devo dizer que sou noob com relação a isso, fiz um curso, na Alura também, sobre o tema, sei uma coisa ou outra, mas tenho que refletir um pouco mais, até que isso faça parte de mim. Com essa carta em jogo, vamos ver um pouco sobre o **S**, ***Single Responsibility Principle***, mantendo o modelo aqui criado, só de traduzir o principio vemos que é algo sobre *responsabilidade unica*. Tá, vamos olhar para o código. Tudo o que foi escrito até agora, esta dentro dum único arquivo, dentro duma única classe, bem está tudo certo, né? A minha classes *Main* tem a única responsabilidadade de lidar com a aplicação inteira, vida que segue.

Para evitar que algumas topeira pensem assim, podemos dar um pouco mais de contexto para elas, afinal de contas, até o GPT precisa de contexto para não gerar respostas estupidas.

>Uma classe deve ter um, e somente um, motivo para mudar.

A partir daqui é só refletir o que essa máxima quer dizer. Pois ao meu ver, é ajuda tanto quanto atrapalha, o que é "somente um motivo"? Eu me debato sobre isso até hoje, uma coisa é pegar um exemplo pronto na internet e deixer que entendeu, outra é fazer um do zero, somente você e Deus.

## Referências

- [REFACTORING GURU, Catálogo refatoração](https://refactoring.guru/pt-br/refactoring/catalog)
- [RAFAEL SOUZA, Não Se Repita (DRY Don’t Repeat Yourself)](https://medium.com/@rafaelsouzaim/n%C3%A3o-se-repita-dry-dont-repeat-yourself-40da33289bcf)
- [JOÃO ROBERTO PAIXÃO - O que é SOLID: O guia completo para você entender os 5 princípios da POO](https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530)
  