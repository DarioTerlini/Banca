package it.exolab.bancaEJB.controllerBean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.bancaDB.cruds.ContoCorrenteCrud;
import it.exolab.bancaDB.cruds.UserContoCorrenteCrud;
import it.exolab.bancaDB.mappers.ContoCorrenteMapper;
import it.exolab.bancaDB.mappers.UserContoCorrenteMapper;
import it.exolab.bancaDB.models.ContoCorrente;
import it.exolab.bancaDB.models.User;
import it.exolab.bancaDB.models.UserContoCorrente;
import it.exolab.bancaEJB.connectionDB.SqlMapFactory;
import it.exolab.bancaEJB.interfaces.CommonInterface;

@Stateless
@LocalBean
public class CommonController implements CommonInterface {
	
	
	public ContoCorrente insertContoByCommon(ContoCorrente contoCorrente) throws Exception {
	try {
		System.out.println("nell'insertConto with Commoncontroller");
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
}

