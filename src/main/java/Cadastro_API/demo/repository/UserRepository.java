package Cadastro_API.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import Cadastro_API.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	boolean existsByEmail(String email);
}

