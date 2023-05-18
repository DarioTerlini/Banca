package it.exolab.bancaRest.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import it.exolab.bancaDB.models.ContoCorrente;
import it.exolab.bancaDB.models.Transazione;
import it.exolab.bancaDB.models.User;
import it.exolab.bancaEJB.interfaces.ContoCorrenteInterface;
import it.exolab.bancaEJB.interfaces.TransazioneInterface;
import it.exolab.bancaEJB.interfaces.UserInterface;
import it.exolab.bancaRest.config.EJBFactory;

@Path("/transazioneRest")
public class TransazioneRest {
	
	private TransazioneInterface transazioneInterface;
	
	@GET
	@Path("/findAll")
	@Produces({"application/json"})
	public Response findAll() {
		System.out.println("sei dentro " +this.getClass() + "nel servizio - findAll Transazione");
		
		try {
			transazioneInterface = new EJBFactory<TransazioneInterface>(TransazioneInterface.class).getEJB();
			List<Transazione> listaTransazioni = transazioneInterface.findAll();
			return Response.status(200).entity(listaTransazioni).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/insertTransazione")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Transazione transazione) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - insertUser - input -> " + transazione);
		try {
			transazioneInterface = new EJBFactory<TransazioneInterface>(TransazioneInterface.class).getEJB();
			transazione = transazioneInterface.insert(transazione);
			return Response.status(201).entity(transazione).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@PUT
	@Path("/gestisciTransazione")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response gestisciTransazione(Transazione transazione) {
		System.out.println("sei dentro " + this.getClass() + " nel servizio rest - gestisciTransazione");
		try {
			transazioneInterface = new EJBFactory<TransazioneInterface>(TransazioneInterface.class).getEJB();
			transazione = transazioneInterface.gestisciTransazione(transazione);
			return Response.status(201).entity(transazione).build();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/findById")
	@Produces({ "application/json" })
	public Response findTransazioneById(Transazione transazione) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - getTransazione - idTransazione - input -> " + transazione);
		try {
			transazioneInterface = new EJBFactory<TransazioneInterface>(TransazioneInterface.class).getEJB();
			transazione = transazioneInterface.findById(transazione);
			return Response.status(200).entity(transazione).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	@POST
	@Path("/findAllTransazioneByIdStato")
	@Produces({"application/json"})
	public Response findAllTransazioneByIdStato(Transazione transazione) {
		System.out.println("sei dentro " +this.getClass() + "nel servizio - findAll ContoCorrente by Stato");
		
		try {
			transazioneInterface = new EJBFactory<TransazioneInterface>(TransazioneInterface.class).getEJB();
			List<Transazione> listaTransazioni = transazioneInterface.findAllTransazioneByIdStato(transazione);
			return Response.status(200).entity(listaTransazioni).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
}
