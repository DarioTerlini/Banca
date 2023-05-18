package it.exolab.bancaEJB.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.bancaDB.models.Transazione;

@Local
public interface TransazioneInterface {

	List<Transazione> findAll();

	Transazione insert(Transazione transazione);

	Transazione gestisciTransazione(Transazione transazione);

	Transazione findById(Transazione transazione);

	List<Transazione> findAllTransazioneByIdStato(Transazione transazione);

}
