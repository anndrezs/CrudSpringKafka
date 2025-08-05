package Cadastro_API.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @KafkaListener(topics = "usuarios-criados", groupId = "usuarios")
    public void escutar(String nome) {
        System.out.println("Kafka recebeu novo usuário: " + nome);

        
    }
}
