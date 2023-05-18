package it.exolab.banca.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ViewBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4608958039901816829L;

	
	private Integer viewHome = 0;

/*  
 *  0 = introUser.
 *  1 = successCreazioneConto.
 *  2 = riepilogoConto.
 *  3 = CreaConto.
 *  4 = CreaContoCointestato.
 *  5 = ConfermaContoIndividuale.
 *  6 = confermaContoCointestato.
 *  7 = registraCointestatario.
 * 
 * 
 * 
 */
	
	
	public Integer getViewHome() {
		return viewHome;
	}

	public void setViewHome(Integer viewHome) {
		this.viewHome = viewHome;
	}
}
