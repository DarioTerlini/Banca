package it.exolab.bancaDB.models;

import java.util.List;
import java.util.Objects;

public class StatoContoCorrente {
	
	private Integer idStatoContoCorrente;
	private String descrizione;
	
	List<ContoCorrente> listaConti;

	public Integer getIdStatoContoCorrente() {
		return idStatoContoCorrente;
	}

	public void setIdStatoContoCorrente(Integer idStatoContoCorrente) {
		this.idStatoContoCorrente = idStatoContoCorrente;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<ContoCorrente> getListaConti() {
		return listaConti;
	}

	public void setListaConti(List<ContoCorrente> listaConti) {
		this.listaConti = listaConti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizione, idStatoContoCorrente, listaConti);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatoContoCorrente other = (StatoContoCorrente) obj;
		return Objects.equals(descrizione, other.descrizione)
				&& Objects.equals(idStatoContoCorrente, other.idStatoContoCorrente)
				&& Objects.equals(listaConti, other.listaConti);
	}

	@Override
	public String toString() {
		return "StatoContoCorrente [idStatoContoCorrente=" + idStatoContoCorrente + ", descrizione=" + descrizione
				+ ", listaConti=" + listaConti + "]";
	}
	
}
