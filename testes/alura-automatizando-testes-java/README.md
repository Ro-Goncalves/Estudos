# Boas Práticas de Programação: Automatizando Testes com Java

É sabido de todos, desenvolvedores, ou deveria ser, que toda aplicação DEVE ser testada, e é isso que será mostrado agora no curso da Alura.

Meu foco não será descrever tudo o que foi feito no curso, e sim criar um guia para as ferramentas atilizadas, se quiserem saber mais sobre o que foi mostrado, o link do curso está nas referências.

## Sobre Teste

Não é necessário testar tudo no código, e sim aquilo que tem alguma regra de negócio, validações, calculos, enfim, qualquer lógica aplicada.

Existe uma tal de pirâmide de testes, que é a ordem em que os testes devem ser executados. Então começemos do começo, os teste unitários. Neles testamos toda nossa lógica criando cenários para cada casso possível.

Vai acontecer momentos em que os testes irão falhar, e esperodo que o bug seja arrumado, ele pode até mesmo estar no teste que foi escrito.

### Nomes de testes

Para mim, nomes importam. Então eu tento criar nomes bem descritivos para meus testes. Ao longo do tempo criei o seguite padrão:

>quandoAlgumaCoisa_deveAlgumaCoisa.

Por exemplo: `quandoPetGatoPesoBaixoIdadeBaixa_deveRetornarProbabilidadeAlta()` e `quandoPetGatoPesoBaixoIdadeAuta_deveRetornarProbabilidadeMedia()`

### Fluxo

Os testes tentem a seguir o mesmo caminho, primeiro criamos aquilo que será usado no cenário, depois executamos alguma ação e por fim verificamos se tudo ocorreu como esperado.

Alguns utilizando **ARRANGE, ACT e ASSERT** para separar as partes do código. Eu gosto de usar **Given, When e Then**, tudo questão de gosto.

```java
@Test
    void quandoPetGatoPesoBaixoIdadeBaixa_deveRetornarProbabilidadeAlta() {
        //Given
        var calculador = new CalculadoraProbabilidadeAdocao();

        //When
        var probabilidade = calculador.calcular(new Pet(
            //Sim, essas instância de classes deveriam estar em Given
            new CadastroPetDto(TipoPet.GATO, "Nome Pet", "Raça Pet", 4, "Cor Pet", 4.0f),
            new Abrigo(new CadastroAbrigoDto("Nome Abrigo", "Telefone Abrigo", "E-Mail Abrigo"))
        ));

        //Then
        assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }
```

## Junit

### Pacote Principal

Na versão do **Junit** que é usada no projeto, todas as classes e metódos devem ser importados do pacote `org.junit.jupiter.api.`

### Indicando que é um teste

A anotação `@Test`, importada de `import org.junit.jupiter.api.Test` indica a IDE que aquele é um cenário de teste.

### Assertions

Estão presentes no pacote  `org.junit.jupiter.api.Assertions` e são responsáveis por indicar o resultado dos testes. Existem diversas assertions, mas as mais utilizadas são:

- `assertEquals` - verifica se os dois valores são iguais.

## Tecnologias

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[MySQL](https://www.mysql.com)**
- **[Hibernate](https://hibernate.org)**
- **[Flyway](https://flywaydb.org)**
- **[Junit 5](https://junit.org/junit5/)**

## Tags

Testes Automatizados
Testes de Unidade
