package it.exolab.bancaRest.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import it.exolab.bancaDB.models.Ruolo;
import it.exolab.bancaEJB.interfaces.RuoloInterface;
import it.exolab.bancaRest.config.EJBFactory;

@Path("ruoloRest")
public class RuoloRest {
	
	private RuoloInterface ruoloInterface;
	
	@GET
	@Path("/findAll")
	@Produces({"application/json"})
	public Response findAllRuolo() {
		System.out.println("sei dentro " +this.getClass() + "nel servizio - findAll ruolo");
		
		try {
			ruoloInterface = new EJBFactory<RuoloInterface>(RuoloInterface.class).getEJB();
			List<Ruolo> listaRuoli = ruoloInterface.findAllRuolo();
			return Response.status(200).entity(listaRuoli).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}
