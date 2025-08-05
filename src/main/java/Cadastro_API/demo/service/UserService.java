package Cadastro_API.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cadastro_API.demo.dto.UserDTO;
import Cadastro_API.demo.model.User;
import Cadastro_API.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User create(UserDTO dto) {
		if (repository.existsByEmail(dto.email)) {
			throw new RuntimeException("email já cadastrado");
		}
		User user = new User();
		user.setName(dto.name);
		user.setEmail(dto.email);
		user.setPassword(dto.password);
		return repository.save(user);
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}

