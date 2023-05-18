package it.exolab.bancaDB.cruds;

import java.util.List;

import it.exolab.bancaDB.mappers.RuoloMapper;
import it.exolab.bancaDB.models.Ruolo;

public class RuoloCrud {

	public List<Ruolo> findAllRuolo(RuoloMapper mapper) {
		List<Ruolo> listaRuolo = mapper.findAllRuolo();
		return listaRuolo;
	}

}
