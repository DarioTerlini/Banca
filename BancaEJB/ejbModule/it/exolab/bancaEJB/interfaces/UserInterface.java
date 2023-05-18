package it.exolab.bancaEJB.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.bancaDB.models.User;



@Local
public interface UserInterface {
	
	List<User>findAll();

	User insert(User user);

	User findByEmailAndPassword(User user);

	User update(User user);

	User findById(User user);

	List<User> findAllTransazioneByIdUser(User user);
	
	User findByEmail(User user);
}
