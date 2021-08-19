package movies;

import java.sql.*;

public class select {

  public static void main( String args[] ) {

   Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Movies;" );
      
      while ( rs.next() ) {
         int id = rs.getInt("ID");
         String  name = rs.getString("NAME");
         String  actor = rs.getString("ACTOR");
         String  actress = rs.getString("ACTRESS");
         String  director = rs.getString("DIRECTOR");
         int year  = rs.getInt("YEAR");
         
         
         System.out.println( "ID = " + id );
         System.out.println( "NAME = " + name );
         System.out.println( "ACTOR = " + actor );
         System.out.println( "ACTRESS = " + actress );
         System.out.println( "DIRECTOR = " + director );
         System.out.println( "YEAR = " + year );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("Operation done successfully");
  }
}