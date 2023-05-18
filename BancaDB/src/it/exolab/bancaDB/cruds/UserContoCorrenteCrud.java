package it.exolab.bancaDB.cruds;


import it.exolab.bancaDB.mappers.UserContoCorrenteMapper;

import it.exolab.bancaDB.models.UserContoCorrente;

public class UserContoCorrenteCrud {

	public UserContoCorrente insert(UserContoCorrenteMapper mapper, UserContoCorrente user_ContoCorrente) {
		System.out.println("Sono nel crud insert userContoCorrente---> " + user_ContoCorrente);
		mapper.insert(user_ContoCorrente);
		return user_ContoCorrente;
	}
}
