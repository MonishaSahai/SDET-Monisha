package generic;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	/**
	 * @author Monisha
	 * To fetch the data from Database
	 * @param pass show database Query
	 * @return pass use database Query
	 * @throws SQLException
	 */
            public void dataBaseConnect(Connection con) throws SQLException {
            	try{
            	Driver driverref = new Driver();
            	DriverManager.registerDriver(driverref);
            	ResultSet result = DriverManager.getConnection("Iconstatnts.databaseurl", "un", "pwd")
                .createStatement().executeQuery("select whatever from table_name;");
            	
            	//int result1 = DriverManager.getConnection("Iconstants.databaseurl", "un", "pwd")
            			//.createStatement().executeUpdate("insert into table_name(col1,col2) values ("name"."id"));
            	while(result.next()) {
            		System.out.println(result.getString(1) + "/t" + result.getString(2));
            	}
            	}
            	catch(Exception e) {
            	}
            	finally {
            		con.close();
            		System.out.println("connection closed");
            	}
            	}
            
}
