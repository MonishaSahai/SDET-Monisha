package generic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;

public class DatabaseUtility {
	/**
	 * @author Monisha
	 * To fetch the data from Database
	 * @param pass show database Query
	 * @return pass use database Query
	 * @throws SQLException
	 */
            public void dataBaseConnect(Driver driverRef,Connection con) throws SQLException {
            	try{
            	DriverManager.registerDriver(driverRef);
            	ResultSet result = DriverManager.getConnection("Iconstatnts.databaseurl", "un", "pwd")
                .createStatement().executeQuery("select whatever from table_name;");
            	}
            	catch(Exception e) {
            	}
            	finally {
            		con.close();
            		System.out.println("connection closed");
            	}
            	}
            
}
