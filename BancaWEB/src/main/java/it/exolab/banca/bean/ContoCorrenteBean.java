package it.exolab.banca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.banca.constant.AllConstant;
import it.exolab.bancaDB.models.ContoCorrente;
import it.exolab.bancaDB.models.User;
import it.exolab.bancaEJB.interfaces.CommonInterface;
import it.exolab.bancaEJB.interfaces.ContoCorrenteInterface;


@Named
@SessionScoped
public class ContoCorrenteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7338876087865039870L;

	
	@EJB
	private ContoCorrenteInterface contoCorrenteInterface;
	
	@EJB
	private CommonInterface commonInterface;
	
	@Inject
	private UserBean userBean;
	
	@Inject
	private MessaggioBean messaggioBean;
	
	@Inject
	private ViewBean viewBean;
	
	

	
	private ContoCorrente contoCorrente;
	private List<ContoCorrente> listaConti;
	private List<ContoCorrente> listaContiUser;
	private List<ContoCorrente> listaRiepilogoConti;
	
	private boolean isShowAllConti = false;
	private boolean isShowAllContiUser = false;
	private boolean isContoAperto = false;
	private boolean isContoCointestato = false;
	private boolean isRegistraCointestatario = false;
	
	private User user;
	private List<User> listaUserConto;
	private Integer idUser;
	
	@PostConstruct
	public void init() {	    	    
			try {
				listaConti = contoCorrenteInterface.findAllContoCorrente();
				System.out.println(listaConti);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	    loadContiDelloUser();	    	 	    
	}
	
	//Questo metodo serve per effetturare nuovamente il findContoByIdUser, in questo modo sono riuscito a aggiornare il componente
	public void loadContiDelloUser() {
		try {
			 Integer idUser = userBean.getUser().getIdUser();
			 listaContiUser = contoCorrenteInterface.findByIdUser(idUser);
			 System.out.println("in load conti dello user" + listaContiUser);
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("errore", null);
		}
	}
   //metodo per aprire conto corrente senza cointestatari
	public void apriConto() {
		try {
			contoCorrente = new ContoCorrente();	
			contoCorrente.setSaldo(AllConstant.getSaldoIniziale());
			contoCorrente.setIdStatoContoCorrente(AllConstant.getStatoContoAttivo());
			listaUserConto = new ArrayList<>();
			listaUserConto.add(userBean.getUser());
			contoCorrente.setListaUserConti(listaUserConto);
			contoCorrente = contoCorrenteInterface.insert(contoCorrente);
			messaggioBean.messaggioConfermaCreazioneConto();
			loadContiDelloUser();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("errore", null);
		}
	}
	
	//metodo per aprire conto corrente con cointestatari
	public void apriContoCointestato() {
		try {
			contoCorrente = new ContoCorrente();	
			contoCorrente.setSaldo(AllConstant.getSaldoIniziale());
			contoCorrente.setIdStatoContoCorrente(AllConstant.getStatoContoAttivo());
			listaUserConto = new ArrayList<>();
			listaUserConto = userBean.getListaUserCointestatario();
			listaUserConto.add(userBean.getUser());
			contoCorrente.setListaUserConti(listaUserConto);
			commonInterface.insertContoByCommon(contoCorrente);
			messaggioBean.messaggioConfermaCreazioneContoCointestato();				
			viewBean.setViewHome(1);			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("errore", null);
		}
	}
	
	//METODI PER CAMBIARE VALORI BOOLEANI
	public void showContiUser() {    
	    isShowAllContiUser = !isShowAllContiUser;
	}
	public void showConti() {
		isShowAllConti = !isShowAllConti;
	}
	
	public void changeIsContoAperto() {
		isContoAperto = !isContoAperto;
	}
	
	public void changeIsContoCointestato() {
		isContoCointestato = !isContoCointestato;
		
	}
	public void changeisRegistraCointestatario() {
		isRegistraCointestatario = !isRegistraCointestatario;
		
	}
	
	//RESET VARIABILE E USER COINTESTATARIO.... DA RIVEDERE
	public void allVariableFalse() {
		isShowAllConti = false;
		isShowAllContiUser = false;
		isContoAperto = false;
		isContoCointestato = false;
		isRegistraCointestatario = false;
		userBean.setIfUserTrovato(false);
		userBean.setIfUserNonTrovato(false);
		userBean.getUserCointestatario().setEmail("");
		userBean.getUserCointestatario().setNome("");
		userBean.getUserCointestatario().setCognome("");
		
	}
	
	//GETTER E SETTER	
	public ContoCorrenteInterface getContoCorrenteInterface() {
		return contoCorrenteInterface;
	}
	public void setContoCorrenteInterface(ContoCorrenteInterface contoCorrenteInterface) {
		this.contoCorrenteInterface = contoCorrenteInterface;
	}
	public ContoCorrente getContoCorrente() {
		return contoCorrente;
	}
	public void setContoCorrente(ContoCorrente contoCorrente) {
		this.contoCorrente = contoCorrente;
	}
	public List<ContoCorrente> getListaConti() {
		return listaConti;
	}
	public void setListaConti(List<ContoCorrente> listaConti) {
		this.listaConti = listaConti;
	}

	public boolean isShowAllConti() {
		return isShowAllConti;
	}

	public void setShowAllConti(boolean isShowAllConti) {
		this.isShowAllConti = isShowAllConti;
	}

	public boolean isContoAperto() {
		return isContoAperto;
	}

	public void setContoAperto(boolean isContoAperto) {
		this.isContoAperto = isContoAperto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public List<User> getListaUserConto() {
		return listaUserConto;
	}

	public void setListaUserConto(List<User> listaUserConto) {
		this.listaUserConto = listaUserConto;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public List<ContoCorrente> getListaRiepilogoConti() {
		return listaRiepilogoConti;
	}

	public void setListaRiepilogoConti(List<ContoCorrente> listaRiepilogoConti) {
		this.listaRiepilogoConti = listaRiepilogoConti;
	}

	public boolean isShowAllContiUser() {
		return isShowAllContiUser;
	}

	public void setShowAllContiUser(boolean isShowAllContiUser) {
		this.isShowAllContiUser = isShowAllContiUser;
	}


	public boolean isContoCointestato() {
		return isContoCointestato;
	}


	public void setContoCointestato(boolean isContoCointestato) {
		this.isContoCointestato = isContoCointestato;
	}


	public boolean isRegistraCointestatario() {
		return isRegistraCointestatario;
	}


	public void setRegistraCointestatario(boolean isRegistraCointestatario) {
		this.isRegistraCointestatario = isRegistraCointestatario;
	}


	public List<ContoCorrente> getListaContiUser() {
		return listaContiUser;
	}


	public void setListaContiUser(List<ContoCorrente> listaContiUser) {
		this.listaContiUser = listaContiUser;
	}

	public ViewBean getViewBean() {
		return viewBean;
	}

	public void setViewBean(ViewBean viewBean) {
		this.viewBean = viewBean;
	}

	
}
