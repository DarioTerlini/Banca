package it.exolab.bancaEJB.controllerBean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.bancaEJB.interfaces.StatoContoCorrenteInterface;

@Stateless(name="StatoContoCorrenteInterface")
@LocalBean
public class StatoContoCorrenteController implements StatoContoCorrenteInterface {

}
