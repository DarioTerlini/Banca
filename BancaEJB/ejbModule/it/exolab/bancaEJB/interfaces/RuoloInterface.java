package it.exolab.bancaEJB.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.bancaDB.models.Ruolo;

@Local
public interface RuoloInterface {

	List<Ruolo> findAllRuolo();

}
