package it.uniba.dib.ia.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilDB {
	private final static Logger LOGGER = Logger.getLogger(UtilDB.class.getName());
	
	
	
		public UtilDB(){
			Connection c = null;
//			try {
//				LOGGER.addHandler(new FileHandler("MyLogFile.log"));
//			} catch (SecurityException e1) {
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:wines.db");
		      LOGGER.setLevel(Level.INFO);
		      LOGGER.info("into sdsfs");
		      LOGGER.severe("severe eee");
		      LOGGER.fine("fine");
		      LOGGER.finest("finest");;
		      
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		      
		    }
		    System.out.println("Opened database successfully");
		}
}
