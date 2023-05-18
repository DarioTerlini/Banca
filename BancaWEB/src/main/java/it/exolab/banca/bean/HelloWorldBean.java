package it.exolab.banca.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HelloWorldBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 42872130942631851L;
	private String messaggio = "CIAO";
	
	
	public HelloWorldBean() {}
	
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	public String getMessaggio() {
		return this.messaggio;
	}
}
