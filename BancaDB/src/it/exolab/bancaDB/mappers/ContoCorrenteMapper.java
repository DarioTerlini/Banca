package it.exolab.bancaDB.mappers;

import java.util.List;

import it.exolab.bancaDB.models.ContoCorrente;

public interface ContoCorrenteMapper {

	List<ContoCorrente> findAllContoCorrente();

	void insert(ContoCorrente contoCorrente);

	ContoCorrente findById(ContoCorrente contoCorrente);

	void update(ContoCorrente contoCorrente);

	List<ContoCorrente> findAllContoByStato(ContoCorrente contoCorrente);

	List<ContoCorrente> findByIdUser(Integer idUser);

}
