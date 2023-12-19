# Estudo de Caso

## Instalar node js

```terminal
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh

curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh | bash

source ~/.bashrc

nvm install [VERSÃO]
```

## Instalar CLI do nest.js

```terminal
npm install -g @nestjs/cli
```

## Criando um projeto nest.js

Na pasta do projeto, executar

```terminal
nest new [NOME PROJETO]
```

Como genrenciador de pacotes podemos ter o NPM

## Recomendações de extensões

* ESLint
* Prettier
* Rest Client
* Prisma

## Subir o projeto em modo desenvolvimento

```console
npm run start:dev
```

## Criando domínios

Començando com o básico

```console
#Cria a controller
nest g controller products

#Cria a service
nest g service products

#Criar módulo
nest g module prisma

#Criar um filter
nest g filter not-found-error
```

Para gerar um crud completo

```console
nest g resource
```

Depois é só dar o nome do recurso, escolher o tipo de transporte, nesse caso REST API, por fim, um sim para criar todos os verbos.

## ORM

Instalando Prisma

```console
npx prisma init
```

Criando modelos

```console
npx prisma migrate dev
```

## Um pouco sobre o Nest

Tudo começa na `main.ts`, ela tem a função que inicia a aplicação. Essa classe cria um `AppModule`, que é o módulo raiz da nossa aplicação.

Para fazer validações podemos usar as libs

```console
npm install class-validator class-transformer
```
