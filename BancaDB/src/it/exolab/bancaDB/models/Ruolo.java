package it.exolab.bancaDB.models;

import java.util.List;
import java.util.Objects;

public class Ruolo {

	private Integer idRuolo;
	private String descrizione;
	private List<User> listaUser;
	
	
	//GETTER E SETTER
	
	public Integer getIdRuolo() {
		return idRuolo;
	}
	public List<User> getListaUser() {
		return listaUser;
	}
	public void setListUser(List<User> listaUser) {
		this.listaUser = listaUser;
	}
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descrizione, idRuolo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruolo other = (Ruolo) obj;
		return Objects.equals(descrizione, other.descrizione) && Objects.equals(idRuolo, other.idRuolo);
	}
	@Override
	public String toString() {
		return "Ruolo [idRuolo=" + idRuolo + ", descrizione=" + descrizione + "]";
	}
	
	
}
