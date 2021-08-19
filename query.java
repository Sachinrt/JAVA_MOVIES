package movies;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
public class query 

{
	private Connection connect() 
	{
		 Connection conn = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         conn = DriverManager.getConnection("jdbc:sqlite:test.db");
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	      return conn;
    }
	
	public void d(int i )
      {
          String sql = "SELECT NAME, ACTOR,ACTRESS,DIRECTOR,YEAR "
                     + "FROM Movies WHERE ID > ?";
   
   try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql))
   {
       
       // set the value
       pstmt.setInt(1,i);
       //
       ResultSet rs  = pstmt.executeQuery();
       
      
      
           System.out.println( 
                              rs.getString("NAME") + "\t" +
                              rs.getString("ACTOR") + "\t" +
                              rs.getString("ACTRESS") + "\t" +
                              rs.getString("DIRECTOR") + "\t" +
                              rs.getInt("YEAR"));
       
   } 
   catch (SQLException e) 
   {
       System.out.println(e.getMessage());
   }
  }
	public static void main(String args[])
	{
   Scanner sc= new Scanner(System.in);
   System.out.println("Enter ID of the movie you want to search");
   int i= sc.nextInt();
   query app = new query();
   
   app.d(i);
   sc.close();
	}

}



