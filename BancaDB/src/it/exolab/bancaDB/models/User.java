package it.exolab.bancaDB.models;

import java.util.List;
import java.util.Objects;

public class User {
	private Integer idUser;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private Integer idRuolo;
	
	private Ruolo ruolo;
	private List<ContoCorrente> listaContiUser;
	private List<Transazione> listaTransazioni;
	
	public User(Integer idUser2) {
		
	}

	public User() {
		
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password="
				+ password + ", idRuolo=" + idRuolo + ", ruolo=" + ruolo + ", listaContiUser=" + listaContiUser
				+ ", listaTransazioni=" + listaTransazioni + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, email, idRuolo, idUser, listaContiUser, listaTransazioni, nome, password, ruolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(email, other.email)
				&& Objects.equals(idRuolo, other.idRuolo) && Objects.equals(idUser, other.idUser)
				&& Objects.equals(listaContiUser, other.listaContiUser)
				&& Objects.equals(listaTransazioni, other.listaTransazioni) && Objects.equals(nome, other.nome)
				&& Objects.equals(password, other.password) && Objects.equals(ruolo, other.ruolo);
	}

	//GETTER E SETTER
	public Integer getIdRuolo() {
		return idRuolo;
	}
	
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}
	
	public Ruolo getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Transazione> getListaTransazioni() {
		return listaTransazioni;
	}

	public void setListaTransazioni(List<Transazione> listaTransazioni) {
		this.listaTransazioni = listaTransazioni;
	}


	public List<ContoCorrente> getListaContiUser() {
		return listaContiUser;
	}

	public void setListaContiUser(List<ContoCorrente> listaContiUser) {
		this.listaContiUser = listaContiUser;
	}


	
}

