package br.com.alura.mypets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.alura.mypets.infrastructure.AbrigoDomainConfig;

@SpringBootApplication
@EnableScheduling //Cria tipo um agendamento de execução
/*
 * @Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}

public class MyBean {

    @Scheduled(cron = "0 * * * * ?")
    public void scheduledMethod() {
        System.out.println("Executing task at " + new Date());
    }
}
 */
@Import({
	AbrigoDomainConfig.class
})
public class MyPetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPetsApplication.class, args);
	}

}
