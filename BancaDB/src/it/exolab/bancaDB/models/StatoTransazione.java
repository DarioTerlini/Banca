package it.exolab.bancaDB.models;

import java.util.List;
import java.util.Objects;

public class StatoTransazione {
	
	private Integer idStatoTransazione;
	private String descrizione;
	
	private List<Transazione> listaTransazioni;

	public Integer getIdStatoTransazione() {
		return idStatoTransazione;
	}

	public void setIdStatoTransazione(Integer idStatoTransazione) {
		this.idStatoTransazione = idStatoTransazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Transazione> getListaTransazioni() {
		return listaTransazioni;
	}

	public void setListaTransazioni(List<Transazione> listaTransazioni) {
		this.listaTransazioni = listaTransazioni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizione, idStatoTransazione, listaTransazioni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatoTransazione other = (StatoTransazione) obj;
		return Objects.equals(descrizione, other.descrizione)
				&& Objects.equals(idStatoTransazione, other.idStatoTransazione)
				&& Objects.equals(listaTransazioni, other.listaTransazioni);
	}

	@Override
	public String toString() {
		return "StatoTransazione [idStatoTransazione=" + idStatoTransazione + ", descrizione=" + descrizione
				+ ", listaTransazioni=" + listaTransazioni + "]";
	}
	
}
