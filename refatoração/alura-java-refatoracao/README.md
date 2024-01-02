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

Não sei ao certo se o que vou falar entra nesse tópico também, creio que sim, seguirei como se fosse sim. 

## 

## Referências

- [REFACTORING GURU, Catálogo refatoração](https://refactoring.guru/pt-br/refactoring/catalog)
- [RAFAEL SOUZA, Não Se Repita (DRY Don’t Repeat Yourself)](https://medium.com/@rafaelsouzaim/n%C3%A3o-se-repita-dry-dont-repeat-yourself-40da33289bcf)