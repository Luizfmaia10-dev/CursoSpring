package com.example.arquiteturaspring;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		//Com o buider conseguimos configurar a aplicação, como por exemplo desabilitar o banner e definir os profiles
		//algumas coisas temos que fazer antes do run, como por exemplo definir o profile, pois se fizermos depois do run não vai funcionar.
		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("teste");


		builder.run(args);

		//contexto da aplicação ja iniciado, podemos pegar o contexto da aplicação e pegar os beans que estão registrados no contexto, como por exemplo o produtoRepository
		//bean é uma instância de uma classe que é gerenciada pelo Spring, ou seja, o Spring cria a instância da classe e gerencia o ciclo de vida dela, como por exemplo a criação, inicialização e destruição da instância.

		ConfigurableApplicationContext context = builder.context();
		//pegamos o contexto da aplicação e conseguimos pegar os beans que estão registrados no contexto, como por exemplo o produtoRepository
		//var enviroment = applicationContext.getBean("produtoRepository");
		ConfigurableEnvironment environment = context.getEnvironment();
		String value = environment.getProperty("spring.application.name");
		System.out.println("Nome da aplicação: " + value);
		//dentro de enviroment conseguimos ler as propriedades do application.properties, como por exemplo o nome da aplicação, que é o spring.application.name
		//o terminal nos da acesso a maioria desses dados então podemos pegar o nome da aplicação, a porta que está rodando, o profile que está rodando, porta,conexao,LOGS entre outros.
	}

}
