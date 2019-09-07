package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	
	public static Connection getConnection(){
		Connection con=null;
		try{
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cbos","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static ArrayList<Glossary_Item> getGlossaryById(int id){
		
		ArrayList<Glossary_Item> items =new ArrayList<Glossary_Item>();
		try{
			Connection con=Dao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from glossary_details where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Glossary_Item g=new Glossary_Item();
				g.setId(rs.getInt(1));
				g.setWord(rs.getString(2));
				g.setDefn(rs.getString(3));
				
				items.add(g);
			}
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
	return items;
	}
}
