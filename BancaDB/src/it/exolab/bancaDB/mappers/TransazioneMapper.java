package it.exolab.bancaDB.mappers;

import java.util.List;

import it.exolab.bancaDB.models.Transazione;

public interface TransazioneMapper {

	List<Transazione> findAll();

	void insert(Transazione transazione);

	Transazione findById(Transazione transazione);

	void gestisciTransazione(Transazione transazione);

	List<Transazione> findAllTransazioneByIdStato(Transazione transazione);

	

}
