package com.Testyantra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC {
	
	   public static void main(String[]args) throws SQLException {
	   Connection con = null;
	    //try {	 
        Driver driverRef = new Driver();
        
        //Step1: Register to Database
        DriverManager.registerDriver(driverRef);
        
        //Step2: Get Connection to Database
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Testyantra","root","root");
        
        //Step3:Issue create statement,statement is an interface having createStat(),we got from con
        Statement stat = con.createStatement();
        
        //Step4: execute query,
        ResultSet result=stat.executeQuery("Select*from Testyantra ");
        
        while (result.next()) {
        	System.out.println(result.getString(1)+"\t"+result.getString(2));
        }
        /*int result = stat.executeUpdate("insert into Testyantra(Name, Id) values ('monisha' ,01)");
        System.out.println(result);
        if(result==1) {
        	System.out.println("Query executed");
        }
        else 
        	System.out.println("Query Failed");
	     }
        catch(Exception e) {
        }
	    finally {
	    	//Step5: Close Connection
	    	con.close();
	    	System.out.println("connection closed");
	    }*/
        con.close();
	   }	   

}