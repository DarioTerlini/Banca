package it.exolab.bancaEJB.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.bancaDB.models.ContoCorrente;

@Local
public interface ContoCorrenteInterface {
	
	List<ContoCorrente> findAllContoCorrente() throws Exception;

	ContoCorrente insert(ContoCorrente contoCorrente) throws Exception;

	ContoCorrente findById(ContoCorrente contoCorrente) throws Exception;

	ContoCorrente update(ContoCorrente contoCorrente);

	List<ContoCorrente> findAllContoByStato(ContoCorrente contoCorrente);

	List<ContoCorrente> findByIdUser(Integer idUser) throws Exception;



	

	

}
