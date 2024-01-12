# Refatorando a Refatoração

É isso o que quero fazer, refatorar o código do curso de refatoração. Ver o quando eu sei e como eu posso evoluir um código que não conheço. ***Lets Bora***.

## Tentando Aplicar Port & Adapter com DDD

A algum tempo venho atrás de tentar entender esses conceitos, para mim é muito dificil. Em minhas andança encontrei um [repositório](https://github.com/wkrzywiec/library-hexagonal) que representa exatamente o que estava tentando criar em minha mente, queria uma forma de ter um código geral, aquele que tem a logica para consultar uma API, fazer consultas SQL, enfim, um local onde tive-se tudo o que seria usado para algo que eu chamava de contexto. Esses contexto podem ser traduzidos como funcionalidades, no meu caso **Processo de Negócio**, é com isso que trabalho, criando **Processo de Negócio** dentro duma ferramenta de **BPM**.

Dizendo duma forma mais concreta, pensei em criar um local onde eu teria a forma como consultar informações do ERP, seja via SQL ou API, com a logica de controle do Processos, abertura, atualização e aprovação e com outras funcionalidade que funcionasem para todos os outros processo. Descobri que a isso é a camada de **Infrastructure** dum projeto de software. Cada Processo que eu desenvolve-se queria que tive-se seu próprio diretório, com toda sua lógica espefica, descobri que a isso damos o nome de **Domain**. Dado a estrutura do projeto como um todo, eu tenho que criar uma classe **Java** que será incluida na aplicação BPM e executará a funcionalidade, descobri que a isso damos o nome de **Application**. No começo eu não sabia de nada disso.

E foi daí que surgiram minhas leituras e reflexões, até achar o artigo que ligava todo esse meu pensamento e dava sentido a ele. E é ele que quero colocar em prática nesse novo desafio. Não irei explicar nenhum desses dois conceitos, e nem explicar em detalhem o que é o repositório ou exatamente o que ele faz. O caso é o seguinte, li esse artigo falando sobre **Port and Adapter (P&A)**, pensei um pouco sobre o tema, e a partir disso tento implementar algo. Um dia tentarei estudar mais afundo esse tema.

E essa é parte do meu pensamento, e uma luta interna também:

>Não temos que saber a fundo como tudo funciona, o mais importante e ter uma ideia e colocar em prática, assim você vai expandindo seu conhecimento aos poucos, vendo os buracos em seu conhecimento.

### O inicio

É fácil ver que existem 3 grandes repositórios no projeto: **application, domain, infrastructure**. Qualquer Google que você der, vai ver que essa é a estrutura do **P&A**, a primeira camada guia o dominio, o dominio tem as regras de negócio e utiliza a ultima para se comunicar com o mundo externo, esse é um **TL;DR**.

Uma outra pasta importante, nesse projeto, é a **domain**, nela vemos que existem outra: **borrowing, email, inventory, user**. Bem, aqui pelo visto é **DDD**, onde cada uma dessas pastas representa um funcionalidade da nossa aplicação.

Dentro de cada uma dessas pastas voltamos ao **P&A**, temos os diretórios: **application, core, infrastructure**. Em application temos as `Controllers`, em core a regra de negócio e em infrastructure a comunicação com o mundo externo. Para saber mais sobre esse projeto, procurem o artigo dele, eu o perdi, sim - sou uma anta. Claro que criar tudo isso nesse projeto pegueno pode nem fazer sentido, foda-se, quero me forçar a fazer algo novo, e com isso aprender alguam coisa.

### Fase 1

Primeiro eu criaria os diretórios do projeto, e colocaria as classes onde eu acho que deveria. Refatoração é assim, ao menos para mim, vamos fazendo a aprendendo com o tempo. Na camada de de aplicação eu criei o diretório cli e coloquei a classe `AdopetConsoleApplication` nela. Na camada de infraestrutura eu coloquei a classe `ClientHttpConfiguration`. Criei dois dominos o pet e o abrigo, coloquei os arquivos referente a eles no diretório core dessa camada.

>Nesse ponto eu não sei o que fazer com o modelo `Abrigo`, pois ele tem uma lista de `Pet`, que está e outro domino.  
A questão:  
O modelo de um dominio, pode ter uma referencia do modelo de outro dominio?  
Creio que não. Tenho uma possível solução, por hora, vida que segue.

As classes `Command` e `CommandExecutor` estão soltar por aí, já eu vejo onde coloca-las.

### Fase 2

Uma das primeiras coisas que faria e remover aquilo que considere responsabilidade da camada de **Infrastructure**.

```java
String uri = "http://localhost:8080/abrigos/" +idOuNome +"/pets";        
    HttpResponse<String> response = client.dispararRequisicaoGet(uri);
    int statusCode = response.statusCode();
    if (statusCode == 404 || statusCode == 500) {
        System.out.println("ID ou nome não cadastrado!");
    }
```

## Referências

-[GIT - wkrzywiec - library-hexagonal](https://github.com/wkrzywiec/library-hexagonal)
