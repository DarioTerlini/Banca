package it.exolab.bancaDB.mappers;

import java.util.List;

import it.exolab.bancaDB.models.User;

public interface UserMapper {
	
	List<User>findAll();
	
	void insert(User user);

	User findByEmailAndPassword(User user);

	User findById(User user);

	void update(User user);

	List<User> findAllTransazioneByIdUser(User user);

	

	User findByEmail(User user);
	}

