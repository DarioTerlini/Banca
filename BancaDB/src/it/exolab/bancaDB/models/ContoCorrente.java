package it.exolab.bancaDB.models;

import java.util.List;
import java.util.Objects;

public class ContoCorrente {
	private Integer idContoCorrente;
	private String dataCreazione;
	private Double saldo;
	private Integer idStatoContoCorrente;
	private String iban;
	
	
	
	private StatoContoCorrente statoConto;
	private List<User> listaUserConti;
	List<Transazione> listaTransazioni;
	
	
	
	
	public ContoCorrente() {
		generaIban();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCreazione, idContoCorrente, idStatoContoCorrente, listaTransazioni,
				listaUserConti, saldo, statoConto, iban);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		return Objects.equals(dataCreazione, other.dataCreazione)
				&& Objects.equals(idContoCorrente, other.idContoCorrente)
				&& Objects.equals(idStatoContoCorrente, other.idStatoContoCorrente)
				&& Objects.equals(iban, other.iban)
				&& Objects.equals(listaTransazioni, other.listaTransazioni)
				&& Objects.equals(listaUserConti, other.listaUserConti) && Objects.equals(saldo, other.saldo)
				&& Objects.equals(statoConto, other.statoConto);
	}
	
	@Override
	public String toString() {
		return "ContoCorrente [idContoCorrente=" + idContoCorrente + ", dataCreazione=" + dataCreazione + ", saldo="
				+ saldo +", idStatoContoCorrente=" + idStatoContoCorrente + ", statoConto="
				+ statoConto + ", listaUserConti=" + listaUserConti + ", listaTransazioni=" + listaTransazioni + ", iban=" + iban + "]";
	}
	

	private void generaIban() {
	    String prefissoIban = "IT";
	    String zeros = "000000";
	    int codiceIban = (int) (Math.random() * 20000);
	    String ibanCompleto = prefissoIban + zeros + codiceIban;
	    setIban(ibanCompleto);
	}
	
	//GETTER E SETTER
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public Integer getIdContoCorrente() {
		return idContoCorrente;
	}
	public List<Transazione> getListaTransazioni() {
		return listaTransazioni;
	}
	public void setListaTransazioni(List<Transazione> listaTransazioni) {
		this.listaTransazioni = listaTransazioni;
	}
	public void setIdContoCorrente(Integer idContoCorrente) {
		this.idContoCorrente = idContoCorrente;
	}
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Integer getIdStatoContoCorrente() {
		return idStatoContoCorrente;
	}
	public void setIdStatoContoCorrente(Integer idStatoContoCorrente) {
		this.idStatoContoCorrente = idStatoContoCorrente;
	}
	
	public List<User> getListaUserConti() {
		return listaUserConti;
	}
	public void setListaUserConti(List<User> listaUserConti) {
		this.listaUserConti = listaUserConti;
	}
	public StatoContoCorrente getStatoConto() {
		return statoConto;
	}
	public void setStatoConto(StatoContoCorrente statoConto) {
		this.statoConto = statoConto;		
}
	}
