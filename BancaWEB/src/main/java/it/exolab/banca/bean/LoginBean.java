package it.exolab.banca.bean;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
	@Named
	public class LoginBean implements Serializable {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 7768473897510495213L;
	
	
	private String username;
	  private String password;

	  public String getUsername() {
	    return this.username;
	  }

	  public void setUserName(String username) {
	    this.username = username;
	  }

	  public String getPassword() {
	    return this.password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }
	  
	  
}
