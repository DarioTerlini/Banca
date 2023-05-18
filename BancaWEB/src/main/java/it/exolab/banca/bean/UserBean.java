package it.exolab.banca.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.banca.constant.AllConstant;
import it.exolab.bancaDB.models.User;
import it.exolab.bancaEJB.interfaces.ContoCorrenteInterface;
import it.exolab.bancaEJB.interfaces.UserInterface;

@Named
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6916199341302039269L;

	@EJB
	private UserInterface userInterface;

	@EJB
	private ContoCorrenteInterface contoCorrenteInterface;

	@Inject
	private ContoCorrenteBean contoCorrenteBean;

	@Inject
	private MessaggioBean messaggioBean;
	
	@Inject
	private ViewBean viewBean;
	
	
	

	private User user;
	private List<User> listaUser;
	private List<User> listaUserCointestatario;
	
	private boolean isShowAllUser = false;
	private boolean ifUserTrovato = false;
	private boolean ifUserNonTrovato = false;
	private String string = "ciao";
	private User userCointestatario;

	@PostConstruct
	public void init() {
		user = new User();
		userCointestatario = new User();
		listaUser = userInterface.findAll();
		listaUserCointestatario = new ArrayList<>();
	}

	// VARIABILI BOOLEANE
	public void showUsers() {
		isShowAllUser = !isShowAllUser;
	}

	public void userTrovato() {
		ifUserTrovato = !ifUserTrovato;
	}

	public void userNonTrovato() {
		ifUserNonTrovato = !ifUserNonTrovato;
	}

	// METODI USER
	public void findByEmailAndPassword() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		try {
			if(checkUserLogin(user)) {
			User userTrovatoLogin = userInterface.findByEmailAndPassword(user);
			if (null != userTrovatoLogin) {
				user = userTrovatoLogin;			
				String page = (user.getIdRuolo() == AllConstant.getAdmin()) 
						? AllConstant.getHomeAdmin()
						: (user.getIdRuolo() == AllConstant.getUser()) 
							? AllConstant.getHomeUser()
							: AllConstant.getIndex();
				externalContext.redirect(page);
			}
			} else {
				System.out.println("User non trovato");
				messaggioBean.messaggioErrore();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Cerco un user passando il suo idUser e se lo trovo, lo assegno a
	// userCointestatario, dopo di che cambio
	// la variabile booleana, in modo che se lo user esiste, apre il componente per
	// la aprire il conto, in caso contrario
	// avro la possibilità di registrare uno user
	public void findById() {
		try {
			userCointestatario = userInterface.findById(userCointestatario);
			if (userCointestatario != null) {
				System.out.println("user Trovato" + userCointestatario);
				userTrovato();
			} else {
				System.out.println("user inesistente in findById user");
				userNonTrovato();
				userCointestatario = new User();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findByEmailCointestatario() {
	    try {
	        userCointestatario = userInterface.findByEmail(userCointestatario);
	        if (null != userCointestatario) {
	            System.out.println("user Trovato" + userCointestatario);
	            if (!listaUserCointestatario.contains(userCointestatario) && !userCointestatario.getEmail().equals(user.getEmail())) {
	                listaUserCointestatario.add(userCointestatario);
	                viewBean.setViewHome(6);
	                userCointestatario = new User();
	                System.out.println("lista dei cointestatari" + listaUserCointestatario);
	            } else {
	            	messaggioBean.messaggioErroreEmail();
	            }
	        } else {
	            System.out.println("user inesistente in findByEmail");
	            messaggioBean.messaggioUserNonTrovato();
	            userCointestatario = new User();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// redirect nella login per la registrazione
	public void goToRegistrati() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		try {
			externalContext.redirect(AllConstant.getRegistrazione());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// inserimento per lo user
	public void registraUser() {
		try {
			user.setIdRuolo(AllConstant.getUser());
			if(checkUser(user)){
				user = userInterface.insert(user);
				FacesContext context = FacesContext.getCurrentInstance();
				ExternalContext externalContext = context.getExternalContext();
				externalContext.redirect(AllConstant.getHomeUser());
			}else {				
				return;
			}
			} catch (IOException e) {
				e.printStackTrace();
		}
	}

			
		
	// inserimento per lo user che verrà poi registrato come cointestatario
	public void registraUserCointestatario() {

		try {
			userCointestatario.setIdRuolo(AllConstant.getUser());
			if (checkUser(userCointestatario)) {
				System.out.println(userCointestatario + "registra user cointestatario");
				userCointestatario = userInterface.insert(userCointestatario);
				System.out.println(userCointestatario + "registrazione user cointestatario riuscita");				
				messaggioBean.messaggioSuccesso();
				viewBean.setViewHome(4);
			}
		} catch (Exception e) {
			e.printStackTrace();
			messaggioBean.messaggioErrore();
		}

	}

	// Funzione per il logout, che grazie a invalidateSession inizializza tutto e
	// rimanda all'index
	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		externalContext.invalidateSession();
		try {
			externalContext.redirect(AllConstant.getIndex());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resetListAndBackhome() {
		listaUserCointestatario = new ArrayList<>();
		viewBean.setViewHome(0);
		contoCorrenteBean.loadContiDelloUser();
	}
	
	//metodo per controllare l'integrità dello user, booleano perche torna true soltanto se supera tutti i test, altrimenti 
	//ci mostrera messaggio d'errore personalizzato e verra intercettato nel catch
	private boolean checkUser(User user) {
		try {
			boolean userCorretto = true;
			System.out.println("dentro il checkUser");
			String regexNome = "^[A-Za-zÀ-ÖØ-öø-ÿ\\\\s0-9^%§&@$#!]+$";
			if (user.getNome() == null || user.getNome().isEmpty() || !user.getNome().matches(regexNome)) {
				messaggioBean.messaggioErroreNome();
				System.out.println("errore");
				return false;
			}
			if (user.getCognome() == null || user.getCognome().isEmpty()) {
				messaggioBean.messaggioErroreCognome();
				return false;
			}
			String email = user.getEmail();
			String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
			Pattern pattern = Pattern.compile(emailRegex);
			Matcher emailMatcher = pattern.matcher(email);
			if (!emailMatcher.matches() || userInterface.findByEmail(user) != null) {
				messaggioBean.messaggioErroreEmail();
				return false;
			}
			if (user.getPassword() == null || user.getPassword().length() < 6 || user.getPassword().contains(" ")) {
				messaggioBean.messaggioErrorepassword();
				return false;
			}
			System.out.println(user + "in findByEmail nel checkUser");
			return userCorretto;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkUserLogin(User user) {
		try {
			boolean userCorretto = true;
			System.out.println("dentro il checkUserLogin");
			String email = user.getEmail();
			String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	        Pattern pattern = Pattern.compile(emailRegex);
	        Matcher emailMatcher = pattern.matcher(email);
	        if (!emailMatcher.matches() || userInterface.findByEmail(user)== null) {
	        	messaggioBean.messaggioErroreEmailLogin();
	        	return false;
	        }
	        if(user.getPassword()==null || user.getPassword().length()<6) {
	        	messaggioBean.messaggioErrorepassword();
	        	return false;
	        }
	        System.out.println(user + "in findByEmail nel checkUser");
	        return userCorretto;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	// GETTER E SETTER
	public List<User> getListaUser() {
		return listaUser;
	}

	public void setListaUser(List<User> listaUser) {
		this.listaUser = listaUser;
	}

	public boolean isShowAllUser() {
		return isShowAllUser;
	}

	public void setShowAllUser(boolean isShowAllUser) {
		this.isShowAllUser = isShowAllUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public ContoCorrenteBean getContoCorrenteBean() {
		return contoCorrenteBean;
	}

	public void setContoCorrenteBean(ContoCorrenteBean contoCorrenteBean) {
		this.contoCorrenteBean = contoCorrenteBean;
	}

	public User getUserCointestatario() {
		return userCointestatario;
	}

	public void setUserCointestatario(User userCointestatario) {
		this.userCointestatario = userCointestatario;
	}

	public boolean isIfUserTrovato() {
		return ifUserTrovato;
	}

	public void setIfUserTrovato(boolean ifUserTrovato) {
		this.ifUserTrovato = ifUserTrovato;
	}

	public boolean isIfUserNonTrovato() {
		return ifUserNonTrovato;
	}

	public void setIfUserNonTrovato(boolean ifUserNonTrovato) {
		this.ifUserNonTrovato = ifUserNonTrovato;
	}

	public MessaggioBean getMessaggioBean() {
		return messaggioBean;
	}

	public void setMessaggioBean(MessaggioBean messaggioBean) {
		this.messaggioBean = messaggioBean;
	}

	public List<User> getListaUserCointestatario() {
		return listaUserCointestatario;
	}

	public void setListaUserCointestatario(List<User> listaUserCointestatario) {
		this.listaUserCointestatario = listaUserCointestatario;
	}

	

	

}
