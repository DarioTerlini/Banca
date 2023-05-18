package it.exolab.bancaDB.models;

import java.util.Objects;

public class Transazione {
	
	private Integer idTransazione;
	private Double importo;
	private Integer idStatoTransazione;
	private Integer idTipoTransazione;
	private Integer idContoCorrente;
	
	private ContoCorrente contoDellaTransazione;
	private StatoTransazione statoTransazione;
	private TipoTransazione tipoTransazione;
	private User userTransazione;

	public StatoTransazione getStatoTransazione() {
		return statoTransazione;
	}

	public void setStatoTransazione(StatoTransazione statoTransazione) {
		this.statoTransazione = statoTransazione;
	}

	public TipoTransazione getTipoTransazione() {
		return tipoTransazione;
	}

	public void setTipoTransazione(TipoTransazione tipoTransazione) {
		this.tipoTransazione = tipoTransazione;
	}

	public Integer getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(Integer idTransazione) {
		this.idTransazione = idTransazione;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public Integer getIdStatoTransazione() {
		return idStatoTransazione;
	}

	public void setIdStatoTransazione(Integer idStatoTransazione) {
		this.idStatoTransazione = idStatoTransazione;
	}

	public Integer getIdTipoTransazione() {
		return idTipoTransazione;
	}

	public void setIdTipoTransazione(Integer idTipoTransazione) {
		this.idTipoTransazione = idTipoTransazione;
	}

	public Integer getIdContoCorrente() {
		return idContoCorrente;
	}

	public void setIdContoCorrente(Integer idContoCorrente) {
		this.idContoCorrente = idContoCorrente;
	}

	public ContoCorrente getContoDellaTransazione() {
		return contoDellaTransazione;
	}

	public void setContoDellaTransazione(ContoCorrente contoDellaTransazione) {
		this.contoDellaTransazione = contoDellaTransazione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contoDellaTransazione, idContoCorrente, idStatoTransazione, idTipoTransazione,
				idTransazione, importo, statoTransazione, tipoTransazione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transazione other = (Transazione) obj;
		return Objects.equals(contoDellaTransazione, other.contoDellaTransazione)
				&& Objects.equals(idContoCorrente, other.idContoCorrente)
				&& Objects.equals(idStatoTransazione, other.idStatoTransazione)
				&& Objects.equals(idTipoTransazione, other.idTipoTransazione)
				&& Objects.equals(idTransazione, other.idTransazione) && Objects.equals(importo, other.importo)
				&& Objects.equals(statoTransazione, other.statoTransazione)
				&& Objects.equals(tipoTransazione, other.tipoTransazione);
	}

	@Override
	public String toString() {
		return "Transazione [idTransazione=" + idTransazione + ", importo=" + importo + ", idStatoTransazione="
				+ idStatoTransazione + ", idTipoTransazione=" + idTipoTransazione + ", idContoCorrente="
				+ idContoCorrente + ", contoDellaTransazione=" + contoDellaTransazione + ", statoTransazione="
				+ statoTransazione + ", tipoTransazione=" + tipoTransazione + "]";
	}

	public User getUserTransazione() {
		return userTransazione;
	}

	public void setUserTransazione(User userTransazione) {
		this.userTransazione = userTransazione;
	}
	
}
