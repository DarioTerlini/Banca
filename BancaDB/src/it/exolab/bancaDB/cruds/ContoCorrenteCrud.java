package it.exolab.bancaDB.cruds;

import java.util.List;

import it.exolab.bancaDB.mappers.ContoCorrenteMapper;
import it.exolab.bancaDB.models.ContoCorrente;

public class ContoCorrenteCrud {

	public List<ContoCorrente> findAllContoCorrente(ContoCorrenteMapper mapper) {
		List<ContoCorrente> listaConti = mapper.findAllContoCorrente();
		return listaConti;
	}

	public ContoCorrente insert(ContoCorrenteMapper mapper, ContoCorrente contoCorrente) {
		System.out.println("Sono nel crud di insert ContoCorrente ----->" + contoCorrente);
		mapper.insert(contoCorrente);
		return contoCorrente;
	}

	public ContoCorrente findById(ContoCorrenteMapper mapper, ContoCorrente contoCorrente) {
		System.out.println("Sono nel crud di findById ContoCorrente ----->" + contoCorrente);
		contoCorrente = mapper.findById(contoCorrente);
		return contoCorrente;
	}

	public ContoCorrente update(ContoCorrenteMapper mapper, ContoCorrente contoCorrente) {
		System.out.println("Sono nel crud di update ContoCorrente ----->" + contoCorrente);
		mapper.update(contoCorrente);
		return contoCorrente;
	}

	public List<ContoCorrente> findAllContoByStato(ContoCorrenteMapper mapper, ContoCorrente contoCorrente) {
		List<ContoCorrente> listaConti = mapper.findAllContoByStato(contoCorrente);
		return listaConti;
	}

	public List<ContoCorrente> findByIdUser(ContoCorrenteMapper mapper, Integer idUser) {
		System.out.println("nel crud conto - findByIdUSER");
		List<ContoCorrente> listaConti = mapper.findByIdUser(idUser);
		return listaConti;
	}

}
