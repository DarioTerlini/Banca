package it.exolab.bancaDB.models;

import java.util.Objects;

public class UserContoCorrente {
	
	private Integer idUserContoCorrente;
	private Integer idUser;
	private Integer idContoCorrente;
	
	
	
	@Override
	public String toString() {
		return "User_ContoCorrente [idUserContoCorrente=" + idUserContoCorrente + ", idUser=" + idUser
				+ ", idContoCorrente=" + idContoCorrente + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idContoCorrente, idUser, idUserContoCorrente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserContoCorrente other = (UserContoCorrente) obj;
		return Objects.equals(idContoCorrente, other.idContoCorrente) && Objects.equals(idUser, other.idUser)
				&& Objects.equals(idUserContoCorrente, other.idUserContoCorrente);
	}
	public Integer getIdUserContoCorrente() {
		return idUserContoCorrente;
	}
	public void setIdUserContoCorrente(Integer idUserContoCorrente) {
		this.idUserContoCorrente = idUserContoCorrente;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdContoCorrente() {
		return idContoCorrente;
	}
	public void setIdContoCorrente(Integer idContoCorrente) {
		this.idContoCorrente = idContoCorrente;
	}
	
}
