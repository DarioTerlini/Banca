package it.exolab.bancaRest.config;

import javax.naming.InitialContext;

public class EJBFactory<T> {

	private final static String PREFIX = "java:global/BancaEAR/BancaEJB/"; // percorso e nome del progetto con le EJB
	private Class<T> interfaceClass;
		
//	La classe EJBFactory è parametrizzata con il tipo di interfaccia dell'EJB che si vuole ottenere,
//	ha un costruttore che accetta come parametro la classe dell'interfaccia.
		
	public EJBFactory(Class<T> interfaceClass) {
			this.interfaceClass = interfaceClass;
		}
		
//		 Il metodo getEJB restituisce un'istanza di un oggetto EJB,
//		
//		 il metodo getEJB concatena il nome dell'interfaccia dell'EJB alla stringa del prefisso
//		 e quindi usa il metodo lookup dell'oggetto InitialContext per cercare l'EJB.

		@SuppressWarnings("unchecked")
		public T getEJB() throws Exception {
			InitialContext context = new InitialContext(); //punto iniziale per la risoluzione del naming
			return (T) context.lookup(PREFIX + interfaceClass.getSimpleName() + "!" + interfaceClass.getName());
		}
	}

