package it.exolab.bancaEJB.controllerBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.bancaDB.cruds.RuoloCrud;

import it.exolab.bancaDB.mappers.RuoloMapper;

import it.exolab.bancaDB.models.Ruolo;

import it.exolab.bancaEJB.connectionDB.SqlMapFactory;
import it.exolab.bancaEJB.interfaces.RuoloInterface;

@Stateless(name="RuoloInterface")
@LocalBean
public class RuoloController implements RuoloInterface{

	@Override
	public List<Ruolo> findAllRuolo() {
		try {
			SqlMapFactory.instance().openSession();
			RuoloMapper mapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			
			RuoloCrud ruoloCrud = new RuoloCrud();
			List<Ruolo> listaRuolo = ruoloCrud.findAllRuolo(mapper);
			return listaRuolo;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}
	
	
	
	
		
}
