package it.exolab.bancaRest.config;

import java.util.HashSet;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import it.exolab.bancaRest.rest.ContoCorrenteRest;
import it.exolab.bancaRest.rest.RuoloRest;
import it.exolab.bancaRest.rest.TransazioneRest;
import it.exolab.bancaRest.rest.UserRest;
import org.jboss.resteasy.plugins.interceptors.CorsFilter; 



@ApplicationPath("/rest")
                   //L'annotazione @ApplicationPath indica il percorso base per tutti i servizi REST
public class ControllerRestApplication extends Application {
	
	
	private Set<Object> singletons; 
	
//Costruttore della classe di inizializzazione 
	public ControllerRestApplication() { 
		super(); 
		CorsFilter corsFilter = new CorsFilter(); 
		corsFilter.getAllowedOrigins().add("*"); 
		corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH"); 
		singletons = new HashSet<Object>(); 
		singletons.add(corsFilter); 
	} 
	
	
	
	@Override 
	public Set<Object> getSingletons() { 
		return singletons; 
	}
	
	
	
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> set = new HashSet<>();
		set.add(UserRest.class);
		set.add(RuoloRest.class);
		set.add(ContoCorrenteRest.class);
		set.add(TransazioneRest.class);
		return set;
	}
}
