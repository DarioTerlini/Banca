package it.exolab.bancaEJB.controllerBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import it.exolab.bancaDB.cruds.ContoCorrenteCrud;
import it.exolab.bancaDB.cruds.UserCrud;
import it.exolab.bancaDB.cruds.UserContoCorrenteCrud;
import it.exolab.bancaDB.mappers.ContoCorrenteMapper;
import it.exolab.bancaDB.mappers.UserMapper;
import it.exolab.bancaDB.mappers.UserContoCorrenteMapper;
import it.exolab.bancaDB.models.ContoCorrente;
import it.exolab.bancaDB.models.User;
import it.exolab.bancaDB.models.UserContoCorrente;
import it.exolab.bancaEJB.connectionDB.SqlMapFactory;
import it.exolab.bancaEJB.interfaces.ContoCorrenteInterface;



@Stateless(name="ContoCorrenteInterface")
@LocalBean
public class ContoCorrenteController implements ContoCorrenteInterface{

	@Override
	public List<ContoCorrente> findAllContoCorrente() throws Exception {
		try {
			SqlMapFactory.instance().openSession();
			ContoCorrenteMapper mapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);			
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			List<ContoCorrente> listaConti = contoCorrenteCrud.findAllContoCorrente(mapper);
			return listaConti;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			throw new Exception();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public ContoCorrente insert(ContoCorrente contoCorrente) throws Exception {
		System.out.println("nel controller bean contoCorrente" + contoCorrente);
		try {
			SqlMapFactory.instance().openSession();
			ContoCorrenteMapper mapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();		
			contoCorrente = contoCorrenteCrud.insert(mapper, contoCorrente);
			UserContoCorrenteMapper mapper2 = SqlMapFactory.instance().getMapper(UserContoCorrenteMapper.class);
			UserContoCorrenteCrud userContoCrud = new UserContoCorrenteCrud();
			for (User user : contoCorrente.getListaUserConti()) {
				UserContoCorrente userConto = new UserContoCorrente();
				userConto.setIdContoCorrente(contoCorrente.getIdContoCorrente());
				userConto.setIdUser(user.getIdUser());
				userContoCrud.insert(mapper2, userConto);
			}
			SqlMapFactory.instance().commitSession();
			return contoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			throw new Exception();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		
	}
	
	

	@Override
	public ContoCorrente findById(ContoCorrente contoCorrente) throws Exception {
		try {
			System.out.println("nel bean ContoCorrente --->" + contoCorrente);
			SqlMapFactory.instance().openSession();
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			ContoCorrenteMapper mapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);			
			contoCorrente = contoCorrenteCrud.findById(mapper, contoCorrente);
			return contoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			throw new Exception();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		
	}

	@Override
	public ContoCorrente update(ContoCorrente contoCorrente) {
		System.out.println("nel update contoCorrente bean ----->" + contoCorrente);
		try {
			SqlMapFactory.instance().openSession();
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			ContoCorrenteMapper mapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);			
			contoCorrente = contoCorrenteCrud.update(mapper, contoCorrente);
			SqlMapFactory.instance().commitSession();
			return contoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<ContoCorrente> findAllContoByStato(ContoCorrente contoCorrente) {
		try {
			SqlMapFactory.instance().openSession();
			ContoCorrenteMapper mapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);			
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			List<ContoCorrente> listaConti = contoCorrenteCrud.findAllContoByStato(mapper, contoCorrente);
			return listaConti;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<ContoCorrente> findByIdUser(Integer idUser) throws Exception {
		try {
			System.out.println("nel bean ContoCorrente findByIdUser --->");
			SqlMapFactory.instance().openSession();
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			ContoCorrenteMapper mapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);			
			List<ContoCorrente> listaConti = contoCorrenteCrud.findByIdUser(mapper, idUser);
			System.out.println("nel bean ContoCorrente findByIdUser out --->" + listaConti);
			return listaConti;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			throw new Exception();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	

	
	


	
	
	
	

}
