# Boas práticas de programação: melhore o código de uma API Java

Se pararmos de pensar o cerebro atrofia, então, bora para um próximo curso. Como sempre, meu objetivo aqui não é ficar demonstrando código e fazendo muita firula, é pura e simplesmente colocar minhas impressões sobre o curso, quer saber mais, vá faze-lo.

## Separação de responsabilidades

Logo de cara tive uma definição muito boa sobre controller.

>Seu objetivo é controlar o fluxo de execução da aplicação, não deveria ter código e regra de negócio, e de validação. A classe deve apenar coordenar o fluxo de execução de uma requisição.

Isso por sí só, já resume toda a primeira aula. O primeiro passo será remover o código sobre a regra de negócio das `Controllers`.

Não tenho muito o que falar, pois fio realizado aquilo que já fiz em outro curso. Falarei um pouco do que eu teria incluido.

Criamos a classe

```java
@Service
public class EmailService {    

    @Autowired
    private JavaMailSender emailSender;

    public void enviarEmail(String to, String subject, String message){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("adopet@email.com.br");
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);

        emailSender.send(email);
    }    
}
```

Quando o método da classe recebe muitos parâmetros, sim 3 é muito, eu gosto de criar uma classe, nesse caso eu criaria a classe `SenderEmailCommand`, ela teria os atributos necessário, e o meu metódo se chamaria `handle`.

```java
@Service
public class EmailService {    

    @Autowired
    private JavaMailSender emailSender;

    public void handle(SenderEmailCommand command){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("adopet@email.com.br");
        email.setTo(command.to);
        email.setSubject(command.subject);
        email.setText(command.message);

        emailSender.send(email);
    }    
}
```

Tem um outro ponto, em `AdocaoService` que eu mudaria, para mim, não é responsabilidade dela montar o e-mail, e para mim, nem de enviar, só não sei onde colocaria, deixa eu tentar explicar.

```java
//solicitar
emailService.enviarEmail(
            adocao.getPet().getAbrigo().getEmail(),
            "Solicitação de adoção",
            "Olá " +adocao.getPet().getAbrigo().getNome() +"!\n\nUma solicitação de adoção foi registrada hoje para o pet: " +adocao.getPet().getNome() +". \nFavor avaliar para aprovação ou reprovação."
        );

//aprovar
emailService.enviarEmail(
            adocao.getPet().getAbrigo().getEmail(),
            "Adoção aprovada",
            "Parabéns " +adocao.getTutor().getNome() +"!\n\nSua adoção do pet " +adocao.getPet().getNome() +", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +", foi aprovada.\nFavor entrar em contato com o abrigo " +adocao.getPet().getAbrigo().getNome() +" para agendar a busca do seu pet."
        );

//reprovar
emailService.enviarEmail(
            adocao.getPet().getAbrigo().getEmail(),
            "Adoção reprovada",
            "Olá " +adocao.getTutor().getNome() +"!\n\nInfelizmente sua adoção do pet " +adocao.getPet().getNome() +", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +", foi reprovada pelo abrigo " +adocao.getPet().getAbrigo().getNome() +" com a seguinte justificativa: " +adocao.getJustificativaStatus()
        );
```

Primeiro, criar a classe `AbrigoEmailCreator` com os métodos `emailSolicitar`, `emailAprovar` e `emailReprovar`, cada método retorna o seu `SenderEmailCommand`

## O padrão Data Transfer Object

O mundo externo não deve conhecer detalhes do mundo interno, logo, não podemos retornar nossa classe do modelo na API, e nem receber ela como entrada. Temos um padrão de projeto que ajuda com isso, o DTO. Ele é relativamente simples de entender, a controller recebe e retorna um DTO.

## Validações Flexíveis

Quando temos um bando de ifs fazendo algo em nosso código, eles são bons candidados à utilização dos padrões **Strategy e Chain of Responsibility**.

## Otimizações na camada de persistência



## Referências

* [GITHUB - Iluwatar - data transfer object](https://github.com/iluwatar/java-design-patterns/tree/master/data-transfer-object)
* [GITHUB - Iluwatar - strategy](https://github.com/iluwatar/java-design-patterns/tree/master/strategy)
* [GITHUB - Iluwatar - chain of responsibility](https://github.com/iluwatar/java-design-patterns/tree/master/chain-of-responsibility)
