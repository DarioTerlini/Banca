package it.exolab.bancaDB.models;

import java.util.List;
import java.util.Objects;

public class TipoTransazione {
 
	private Integer idTipoTransazione;
	private String descrizioneTipo;
	
	List<Transazione> listaTransazioni;

	public Integer getIdTipoTransazione() {
		return idTipoTransazione;
	}

	public void setIdTipoTransazione(Integer idTipoTransazione) {
		this.idTipoTransazione = idTipoTransazione;
	}

	public String getDescrizioneTipo() {
		return descrizioneTipo;
	}

	public void setDescrizioneTipo(String descrizioneTipo) {
		this.descrizioneTipo = descrizioneTipo;
	}

	public List<Transazione> getListaTransazioni() {
		return listaTransazioni;
	}

	public void setListaTransazioni(List<Transazione> listaTransazioni) {
		this.listaTransazioni = listaTransazioni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizioneTipo, idTipoTransazione, listaTransazioni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoTransazione other = (TipoTransazione) obj;
		return Objects.equals(descrizioneTipo, other.descrizioneTipo)
				&& Objects.equals(idTipoTransazione, other.idTipoTransazione)
				&& Objects.equals(listaTransazioni, other.listaTransazioni);
	}

	@Override
	public String toString() {
		return "TipoTransazione [idTipoTransazione=" + idTipoTransazione + ", descrizioneTipo=" + descrizioneTipo
				+ ", listaTransazioni=" + listaTransazioni + "]";
	}
	
}
