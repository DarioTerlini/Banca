package it.exolab.banca.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class MessaggioBean {

	
	public void messaggioSuccesso() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Operazione riuscita con successo"));
	}
	
	
	public void messaggioConfermaCreazioneConto() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Congratulazioni, Conto Corrente aperto con successo"));
	}
	
	
	
	//ERRORI
	public void messaggioErrore() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ops, qualcosa è andato storto!"));
	}
	
	public void messaggioConfermaCreazioneContoCointestato() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Congratulazioni, Conto Corrente Cointestato aperto con successo. Clicca su back per tornare indietro."));
	}
	public void messaggioErroreEmail() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Email gia in uso o non corretta"));
	}
	public void messaggioErroreEmailLogin() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Email non corretta"));
	}
	public void messaggioErroreNome() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Il campo nome è obbligatorio"));
	}
	public void messaggioErroreCognome() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Il campo cognome è obbligatorio"));
	}
	public void messaggioErrorepassword() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "La password deve superare i 6 caratteri"));
	}
	
	public void messaggioUserNonTrovato() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "User non trovato, registralo ora!"));
	}
}
