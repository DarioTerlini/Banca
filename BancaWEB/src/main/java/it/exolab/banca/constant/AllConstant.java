package it.exolab.banca.constant;

public class AllConstant {
		
	//variabili Redirect
		private static final String HOME_USER = "homeUser.xhtml";
		private static final String HOME_ADMIN = "homeAdmin.xhtml";
		private static final String INDEX = "index.xhtml";
		private static final String REGISTRAZIONE = "registrati.xhtml";
		
	//variabili User
		private static final Integer USER = 3;
		private static final Integer ADMIN = 1;
		
	//variabili Conto Corrente
		private static final Double SALDO_INIZIALE = 0.0;
		private static final Integer STATO_CONTO_ATTIVO = 1;
		

		
		
		
		
		public static String getHomeUser() {
			return HOME_USER;
		}


		public static String getHomeAdmin() {
			return HOME_ADMIN;
		}


		public static Integer getUser() {
			return USER;
		}


		public static Integer getAdmin() {
			return ADMIN;
		}


		public static String getIndex() {
			return INDEX;
		}


		public static String getRegistrazione() {
			return REGISTRAZIONE;
		}


		public static Double getSaldoIniziale() {
			return SALDO_INIZIALE;
		}


		public static Integer getStatoContoAttivo() {
			return STATO_CONTO_ATTIVO;
		}

		
}
