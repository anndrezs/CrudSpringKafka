package Cadastro_API.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Nova tentativa de deploy!");
		SpringApplication.run(DemoApplication.class, args);
	}

}
