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

import it.exolab.bancaEJB.interfaces.ContoCorrenteInterface;

import it.exolab.bancaRest.config.EJBFactory;

@Path("/contoCorrenteRest")
public class ContoCorrenteRest {
	
	private ContoCorrenteInterface contoCorrenteInterface;
	
	@GET
	@Path("/findAllContoCorrente")
	@Produces({"application/json"})
	public Response findAllContoCorrente() {
		System.out.println("sei dentro " +this.getClass() + "nel servizio - findAll ContoCorrente");
		
		try {
			contoCorrenteInterface = new EJBFactory<ContoCorrenteInterface>(ContoCorrenteInterface.class).getEJB();
			List<ContoCorrente> listaConti = contoCorrenteInterface.findAllContoCorrente();
			return Response.status(200).entity(listaConti).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/findAllContoByStato")
	@Produces({"application/json"})
	public Response findAllContoByStato(ContoCorrente contoCorrente) {
		System.out.println("sei dentro " +this.getClass() + "nel servizio - findAll ContoCorrente by Stato");
		
		try {
			contoCorrenteInterface = new EJBFactory<ContoCorrenteInterface>(ContoCorrenteInterface.class).getEJB();
			List<ContoCorrente> listaConti = contoCorrenteInterface.findAllContoByStato(contoCorrente);
			return Response.status(200).entity(listaConti).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/insertContoCorrente")
	@Produces({ "application/json" })
	public Response insert(ContoCorrente contoCorrente) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - insertUser - input -> " + contoCorrente);
		try {
			contoCorrenteInterface = new EJBFactory<ContoCorrenteInterface>(ContoCorrenteInterface.class).getEJB();
			contoCorrente = contoCorrenteInterface.insert(contoCorrente);
			System.out.println(contoCorrente);
			return Response.status(201).entity(contoCorrente).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/getContoById")
	@Produces({ "application/json" })
	public Response findById(ContoCorrente contoCorrente) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - getContoCorrente -> " + contoCorrente);
		try {
			contoCorrenteInterface = new EJBFactory<ContoCorrenteInterface>(ContoCorrenteInterface.class).getEJB();
			contoCorrente = contoCorrenteInterface.findById(contoCorrente);
			return Response.status(200).entity(contoCorrente).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	
	
	@PUT
	@Path("/updateConto")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(ContoCorrente contoCorrente) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - updatecontoCorrente - input -> " + contoCorrente);
		try {
			contoCorrenteInterface = new EJBFactory<ContoCorrenteInterface>(ContoCorrenteInterface.class).getEJB();
			contoCorrente = contoCorrenteInterface.update(contoCorrente);
			return Response.status(200).entity(contoCorrente).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/getContoByIdUser")
	@Produces({ "application/json" })
	public Response findByIdUser(Integer idUser) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - getContoCorrentebyUser -> " +idUser);
		try {
			contoCorrenteInterface = new EJBFactory<ContoCorrenteInterface>(ContoCorrenteInterface.class).getEJB();
			List<ContoCorrente> listaConti = contoCorrenteInterface.findByIdUser(idUser);
			return Response.status(200).entity(listaConti).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

}
