package Cadastro_API.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cadastro_API.demo.dto.UserDTO;
import Cadastro_API.demo.kafka.UserProducer;
import Cadastro_API.demo.model.User;
import Cadastro_API.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private UserProducer producer;

	@PostMapping
	public User create(@RequestBody UserDTO dto) {
		User novoUser = service.create(dto);
		producer.enviarUsuarioCriado(novoUser.getName());
		return novoUser;
	}

	@GetMapping
	public List<User> listAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}




