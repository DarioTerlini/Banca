package it.exolab.bancaEJB.controllerBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.bancaDB.cruds.TransazioneCrud;
import it.exolab.bancaDB.cruds.UserCrud;
import it.exolab.bancaDB.mappers.TransazioneMapper;
import it.exolab.bancaDB.mappers.UserMapper;
import it.exolab.bancaDB.models.Transazione;
import it.exolab.bancaDB.models.User;
import it.exolab.bancaEJB.connectionDB.SqlMapFactory;
import it.exolab.bancaEJB.interfaces.UserInterface;


@Stateless(name="UserInterface")
@LocalBean
public class UserController implements UserInterface{

	@Override
	public List<User> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			UserMapper mapper = SqlMapFactory.instance().getMapper(UserMapper.class);
			
			UserCrud userCrud = new UserCrud();
			List<User> listaUser = userCrud.findAll(mapper);
			return listaUser;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}
	
	public User insert(User user) {
		System.out.println("nel controller insert user---> " + user);
		try {
			SqlMapFactory.instance().openSession();
			UserCrud userCrud = new UserCrud();
			UserMapper mapper = SqlMapFactory.instance().getMapper(UserMapper.class);
			user = userCrud.insert(mapper, user);
			SqlMapFactory.instance().commitSession();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null; 
	}

	@Override
	public User findByEmailAndPassword(User user) {
		System.out.println("nel controllerBean findByEmailAndPassword user----<" +  user);
		try {
			SqlMapFactory.instance().openSession();
			UserCrud userCrud = new UserCrud();
			UserMapper mapper = SqlMapFactory.instance().getMapper(UserMapper.class);
			user = userCrud.findByEmailAndPassword(mapper, user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public User update(User user) {
		System.out.println("update UserBean --> " + user);
		try {	
		SqlMapFactory.instance().openSession();
		    UserCrud userCrud = new UserCrud();
			UserMapper mapper =  SqlMapFactory.instance().getMapper(UserMapper.class);
			userCrud.update(mapper, user);
			user = userCrud.findById(mapper, user);
			SqlMapFactory.instance().commitSession();
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		}finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public User findById(User user) {
		System.out.println("nel controllerBean findById user -----> " + user);
		try {
			SqlMapFactory.instance().openSession();
			UserCrud userCrud = new UserCrud();
			UserMapper mapper = SqlMapFactory.instance().getMapper(UserMapper.class);
			 user = userCrud.findById(mapper, user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			System.out.println("nel catch findById User" + user); 
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<User> findAllTransazioneByIdUser(User user) {
		try {
			SqlMapFactory.instance().openSession();
			UserMapper mapper = SqlMapFactory.instance().getMapper(UserMapper.class);
			
			UserCrud userCrud = new UserCrud();
			List<User> listaUser = userCrud.findAllTransazioneByIdUser(mapper, user);
			return listaUser;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public User findByEmail(User user) {
		try {
			SqlMapFactory.instance().openSession();
			UserMapper mapper = SqlMapFactory.instance().getMapper(UserMapper.class);			
			UserCrud userCrud = new UserCrud();
			
			user = userCrud.findByEmail(mapper, user);
			System.out.println(user + "nel controller user findByEmail");
			return user;
	}catch (Exception e) {
		e.printStackTrace();
		SqlMapFactory.instance().rollbackSession();
	} finally {
		SqlMapFactory.instance().closeSession();
	}
	return null;
}

	

}
