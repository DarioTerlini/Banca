package it.exolab.bancaRest.rest;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.UnhandledException;


import it.exolab.bancaDB.models.User;

import it.exolab.bancaEJB.interfaces.UserInterface;
import it.exolab.bancaRest.config.EJBFactory;


@Path("/userRest") //significa che tutti i metodi definiti in questa classe saranno disponibili all'URL "/userRest"
public class UserRest {
	
	private UserInterface userInterface;
	@GET
	@Path("/findAll")
	@Produces({"application/json"})
	public Response findAll() {
		System.out.println("sei dentro " +this.getClass() + "nel servizio - findAll user");
		
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			List<User> listaUser = userInterface.findAll();
			return Response.status(200).entity(listaUser).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/insertUser")
	@Produces({ "application/json" })	// @Produces e @Consumes specificano il tipo di dati prodotti e consumati dai servizi.
	@Consumes({ "application/json" })
	public Response insert(User user) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - insertUser - input -> " + user);
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			user = userInterface.insert(user);
			System.out.println(user);
			return Response.status(201).entity(user).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/checkLogin")
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response login(User user) {
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			User userTrovato = userInterface.findByEmailAndPassword(user);
			return Response.status(200).entity(userTrovato).build();
		} catch (UnhandledException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return Response.status(500).build();	
		}
	
	@PUT
	@Path("/updateUser")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(User user) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - updateUser - input -> " + user);
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			user = userInterface.update(user);
			return Response.status(200).entity(user).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	
	@POST
	@Path("/getUserById")
	@Produces({ "application/json" })
	public Response findUserById(User user) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - getUser - idUser - input -> " + user);
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			 user = userInterface.findById(user);
			return Response.status(200).entity(user).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/findAllTransazioneByIdUser")
	@Produces({"application/json"})
	public Response findAllTransazioneByIdUser(User user) {
		System.out.println("sei dentro " +this.getClass() + "nel servizio - findAlltransazione by user");
		
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			List<User> listaUser = userInterface.findAllTransazioneByIdUser(user);
			return Response.status(200).entity(listaUser).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}
