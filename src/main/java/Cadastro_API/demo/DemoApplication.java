package Cadastro_API.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Teste Deploy");
		SpringApplication.run(DemoApplication.class, args);
	}

}
