package it.uniba.dib.ia.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class UtilDB {
	private final static Logger LOGGER = Logger.getLogger(UtilDB.class.getName());
	private Connection connection;

	public UtilDB(){
		try {
			connect();
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
		}
	}
	
	public void connect() throws SQLException{
	    try {
	    	Class.forName("org.sqlite.JDBC");
	    	Connection connection = DriverManager.getConnection("jdbc:sqlite:wines.db");
	    	setConnection(connection);
	    	LOGGER.fine("Connected to jdbc:sqlite:wines.db");
	    } catch ( Exception e ) {
	    	LOGGER.severe("Error during connection " +  e.getClass().getName() + ": " + e.getMessage());
	    	throw new SQLException(e);
	    }
	}
	
	public void closeConnection() {
		try{
	        if(getConnection() != null && !getConnection().isClosed()){
	        	getConnection().close();
	        	LOGGER.fine("Connection closed");
	        }else{
	        	LOGGER.warning("Connection already closed");
	        }
		}catch(SQLException e){
	        LOGGER.severe("Error while connection closing" +  e.getClass().getName() + ": " + e.getMessage());
	    }
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public int executeUpdate(String sql) throws SQLException{
	   return executeUpdate(sql, 30); // set timeout to 30 sec.
	}
	
	public int executeUpdate(String sql, int timeout) throws SQLException{
		 try {
			 LOGGER.fine("executeUpdate [" + sql + "]");
			 Statement statement = getConnection().createStatement();
			 statement.setQueryTimeout(timeout); 
			 return statement.executeUpdate(sql);
		} catch (SQLException e) {
			LOGGER.severe("[" + sql + "] : " + e);
			throw e;
		}
	}
	

	public void finalize(){
		closeConnection();
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		try {
			LOGGER.fine("executeQuery [" + sql + "]");
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			LOGGER.severe("[" + sql + "] : " + e);
			throw e;
		}
	}
}