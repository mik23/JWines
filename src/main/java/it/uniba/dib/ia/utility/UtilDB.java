package it.uniba.dib.ia.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class UtilDB {
	private final static Logger LOGGER = Logger.getLogger(UtilDB.class.getName());
		public UtilDB(){
			Connection c = null;
		    try {
		    	Class.forName("org.sqlite.JDBC");
		    	c = DriverManager.getConnection("jdbc:sqlite:wines.db");
		    	LOGGER.fine("Connected to jdbc:sqlite:wines.db");
		    } catch ( Exception e ) {
		    	LOGGER.severe("Error during connection " +  e.getClass().getName() + ": " + e.getMessage());
		    	System.exit(0);
		    }
		    
		}
}
