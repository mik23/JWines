package it.uniba.dib.ia.test;

import java.util.logging.Logger;
import it.uniba.dib.ia.utility.Operation;

public class Test {
	private static final Logger LOGGER = Logger.getLogger(Test.class.getName());
	
	public static void main(String args[]){
		LOGGER.info("Start main");
		Operation.initializeDB();
	}
}
