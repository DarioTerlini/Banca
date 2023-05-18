package it.exolab.bancaDB.cruds;

import java.util.List;

import it.exolab.bancaDB.mappers.UserMapper;
import it.exolab.bancaDB.models.User;

public class UserCrud {
	public List<User> findAll(UserMapper mapper){
		List<User> listaUser = mapper.findAll();
				return listaUser;
	}

	public User insert(UserMapper mapper, User user) {
			System.out.println("Sono nel crud insert user---> " + user);
			mapper.insert(user);
			return user;
		}

	public User findByEmailAndPassword(UserMapper mapper, User user) {
		System.out.println("Sono nel crud findByEmailAndPassword user---> " + user);
		user = mapper.findByEmailAndPassword(user);
		return user;
	}
	public User findById(UserMapper mapper, User user) {
		System.out.println("Sono nel crud findUserByiD user---> " + user);
		user = mapper.findById(user);
		return user;
	}
	
	public User update(UserMapper mapper, User user) {
		System.out.println("sono nel crud updateUser" + user);
		mapper.update(user);
		return user;
		
	}

	public List<User> findAllTransazioneByIdUser(UserMapper mapper, User user) {
		List<User> listaUser = mapper.findAllTransazioneByIdUser(user);
		return listaUser;
	}

	public User findByEmail(UserMapper mapper, User user) {
		System.out.println("Sono nel crud findUserByEmail user---> " + user);
		user = mapper.findByEmail(user);
		return user;
	}
}
