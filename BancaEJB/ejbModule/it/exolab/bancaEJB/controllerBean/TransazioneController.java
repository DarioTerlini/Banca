package it.exolab.bancaEJB.controllerBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.bancaDB.cruds.ContoCorrenteCrud;
import it.exolab.bancaDB.cruds.TransazioneCrud;
import it.exolab.bancaDB.cruds.UserCrud;
import it.exolab.bancaDB.mappers.ContoCorrenteMapper;
import it.exolab.bancaDB.mappers.StatoContoCorrenteMapper;
import it.exolab.bancaDB.mappers.TransazioneMapper;
import it.exolab.bancaDB.mappers.UserMapper;
import it.exolab.bancaDB.models.Transazione;
import it.exolab.bancaEJB.connectionDB.SqlMapFactory;
import it.exolab.bancaEJB.interfaces.TransazioneInterface;

@Stateless(name="TransazioneInterface")
@LocalBean
public class TransazioneController implements TransazioneInterface{

	@Override
	public List<Transazione> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			TransazioneMapper mapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			List<Transazione> listaTransazioni = transazioneCrud.findAll(mapper);
			return listaTransazioni;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public Transazione insert(Transazione transazione) {
		try {
			System.out.println("nell'insert di transazione");
			SqlMapFactory.instance().openSession();
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			TransazioneMapper mapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			transazione = transazioneCrud.insert(mapper, transazione);
			SqlMapFactory.instance().commitSession();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null; 
	}

	@Override
	public Transazione gestisciTransazione(Transazione transazione) {
		try {	
			SqlMapFactory.instance().openSession();
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			TransazioneMapper mapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			transazioneCrud.gestisciTransazione(mapper, transazione);
			transazione = transazioneCrud.findById(mapper, transazione);
//			ContoCorrenteCrud contoCrud = new ContoCorrenteCrud();
//			ContoCorrenteMapper contoMapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);
//			//VERSAMENTO
//			System.out.println(transazione);
//			if(transazione.getContoDellaTransazione().getIdStatoContoCorrente()==1) {
//				if(transazione.getIdTipoTransazione()==2) {
//					transazione.getContoDellaTransazione().setSaldo((transazione.getContoDellaTransazione().getSaldo()+ transazione.getImporto()));
//					contoCrud.update(contoMapper, transazione.getContoDellaTransazione());
//					System.out.println(transazione);
//				}
//			}
			SqlMapFactory.instance().commitSession();
				return transazione;
			}catch(Exception e) {
				e.printStackTrace();
				SqlMapFactory.instance().rollbackSession();
			}finally {
				SqlMapFactory.instance().closeSession();
			}
			return null;
		}

	@Override
	public Transazione findById(Transazione transazione) {
		try {
		SqlMapFactory.instance().openSession();
		TransazioneCrud transazioneCrud = new TransazioneCrud();
		TransazioneMapper mapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
		transazione = transazioneCrud.findById(mapper, transazione);
		return transazione;
	} catch (Exception e) {
		e.printStackTrace();
		SqlMapFactory.instance().rollbackSession();
	} finally {
		SqlMapFactory.instance().closeSession();
	}
	return null; 
	}

	@Override
	public List<Transazione> findAllTransazioneByIdStato(Transazione transazione) {
		try {
			SqlMapFactory.instance().openSession();
			TransazioneMapper mapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			List<Transazione> listaTransazioni = transazioneCrud.findAllTransazioneByIdStato(mapper, transazione);
			return listaTransazioni;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}
}
