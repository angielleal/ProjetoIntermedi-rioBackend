package com.example.projeto.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjetoBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProjetoBackendApplication.class, args);

		ServiceLocalizacao serviceLocalizacao = context.getBean(ServiceLocalizacao.class);

		String cep = "88820000";

		String resultado = serviceLocalizacao.consultarLocalizacao(cep);

		System.out.println("Resposta da API para o CEP " + cep + ":");
		System.out.println(resultado);

		serviceLocalizacao.processarDados(resultado);
	}
}
