package it.exolab.bancaDB.cruds;

import java.util.List;

import it.exolab.bancaDB.mappers.TransazioneMapper;
import it.exolab.bancaDB.models.Transazione;

public class TransazioneCrud {

	public List<Transazione> findAll(TransazioneMapper mapper) {
		 List<Transazione> listaTransazioni = mapper.findAll();
		 System.out.println(listaTransazioni);
		 return listaTransazioni;
	}

	public Transazione insert(TransazioneMapper mapper, Transazione transazione) {
		mapper.insert(transazione);
		return transazione;
	}

	public Transazione findById(TransazioneMapper mapper, Transazione transazione) {
		transazione = mapper.findById(transazione);
		return transazione;
	}

	public Transazione gestisciTransazione(TransazioneMapper mapper, Transazione transazione) {
		mapper.gestisciTransazione(transazione);
		return transazione;
		
	}

	public List<Transazione> findAllTransazioneByIdStato(TransazioneMapper mapper, Transazione transazione) {
		List<Transazione> listaTransazioni = mapper.findAllTransazioneByIdStato(transazione);
		return listaTransazioni;
	}

}
