package it.uniba.dib.ia.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Logger;

public class Operation {
	private final static Logger LOGGER = Logger.getLogger(Operation.class.getName());
	private static final String PATHSQLINIT = "src/main/resources/winesdb.sql";
	
	public static void initializeDB(){
		UtilDB dbUtilDB = new UtilDB();
		try {
			LOGGER.fine("initialize DataBase");
			BufferedReader reader = new BufferedReader(new FileReader(PATHSQLINIT));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				dbUtilDB.executeUpdate(line);
			}
			reader.close();
			
		} catch (Exception e) {
			LOGGER.severe("Error during execution script SQL - error: " + e);
		} finally {
			dbUtilDB.closeConnection();
		}
	}
}
