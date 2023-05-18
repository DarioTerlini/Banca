package it.exolab.bancaEJB.interfaces;

import javax.ejb.Local;

import it.exolab.bancaDB.models.ContoCorrente;

@Local
public interface CommonInterface {

	public ContoCorrente insertContoByCommon(ContoCorrente contoCorrente) throws Exception;
}
