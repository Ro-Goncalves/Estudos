# Go

## Instalar

[Link util](https://www.digitalocean.com/community/tutorials/como-instalar-o-go-e-configurar-um-ambiente-de-programacao-local-no-ubuntu-18-04-pt)

Antes de baixar o Go, certifique-se de estar no diretório home (~):

```console
cd ~
```

Use o curl para recuperar a URL do tarball que você copiou da [página oficial](https://go.dev/dl/) de downloads do Go:

```console
curl -O https://dl.google.com/go/go1.21.5.linux-amd64.tar.gz
```

Em seguida, use sha256sum para verificar o tarball:

```console
sha256sum go1.21.5.linux-amd64.tar.gz
```

O hash que é exibido a partir da execução do comando acima deve corresponder ao hash que estava na página de downloads. Se não, então este não é um arquivo válido e você deve baixar o arquivo novamente.

Em seguida, extraia o arquivo baixado e instale-o no local desejado no sistema. É considerado uma boa prática mantê-lo em /usr/local:

```console
sudo tar -xvf go1.21.5.linux-amd64.tar.gz -C /usr/local
```

Você terá agora um diretório chamado go no diretório /usr/local. Em seguida, altere recursivamente o proprietário e o grupo deste diretório para root:

```console
sudo chown -R root:root /usr/local/go
```

Com o **VS Code** usar `CRTL + P`, procurar por go: Intall/Update tools, e instalar tudo. Para isso funcionar é preciso ter instalado a instensão **GO**

Você pode definir seu $GOPATH adicionando as variáveis globais ao seu ~/.profile. Você pode querer adicionar isto ao arquivo .zshrc ou .bashrc de acordo com a configuração do seu shell.

Primeiro, abra o ~/.profile com o nano ou seu editor de textos preferido:

```console
nano ~/.profile
```

Configure seu $GOPATH adicionando o seguinte ao arquivo:

```console
export GOPATH=$HOME/go
export PATH=$PATH:$GOPATH/bin
export PATH=$PATH:$GOPATH/bin:/usr/local/go/bin
```

Para atualizar seu shell, execute o seguinte comando para carregar as variáveis globais:

```console
. ~/.profile
```

## Iniciando com GO

Para criar o projeto: `go mod init github.com/[USUÁRIO]/[NOME-PROJETO]`

Para rodar um arquivo: `go run [NOME-ARQUIVO]`
