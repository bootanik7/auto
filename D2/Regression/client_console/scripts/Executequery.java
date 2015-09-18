package D2.Regression.client_console.scripts;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import D2.Regression.client_console.applibs.Databaseexe;
import core.libs.Database;

public class Executequery {
	
	@Test
	public void  exe() throws  SQLException, ClassNotFoundException {
		 try{
			 String query="select LOGIN from sp_identity_en where business_id = 563965";
			 Databaseexe.connectD2QA();
			 ResultSet rs = Database.executeDatabaseQuery(query);
			 while(rs.next()){
					System.out.println("the data is=========="+rs.getString(1));

			 }
			 
		 }catch(SQLException e){
			 System.out.println("came here");
			//Database.connection.close();
		 }finally{
			// Database.connection.close();
		 }
	}
	@Test
	public void  exe2() throws  SQLException, ClassNotFoundException {
		 try{
			 String query="select PASSWORD from sp_identity_en where business_id = 563965";
			 Databaseexe.connectD2QA();
			 ResultSet rs = Database.executeDatabaseQuery(query);
			 while(rs.next()){
					System.out.println("the data is=========="+rs.getString(1));

			 }
			 
		 }catch(SQLException e){
			 System.out.println("came here");
			//Database.connection.close();
		 }finally{
			// Database.connection.close();
		 }
	}
	

}
