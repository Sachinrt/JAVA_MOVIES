package movies;

import java.sql.*;

public class insert {

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO Movies (ID,NAME,ACTOR,ACTRESS,DIRECTOR,YEAR) " +
                        "VALUES (1, 'Good Newwz', 'Akshay Kumar', 'Kareena Kapoor Khan','Director 1', 2019 );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Movies (ID,NAME,ACTOR,ACTRESS,DIRECTOR,YEAR) " +
                  "VALUES (2, 'Housefull 4', 'Akshay Kumar', 'Kriti Sanon','Director 1', 2019);"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Movies (ID,NAME,ACTOR,ACTRESS,DIRECTOR,YEAR) " +
                  "VALUES (3, 'Mission Mangal', 'Akshay Kumar', 'Vidya Balan','Director 1', 2019 );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Movies (ID,NAME,ACTOR,ACTRESS,DIRECTOR,YEAR) " +
                  "VALUES (4, 'Kesari ', 'Akshay Kumar', 'Parineeti Chopra ','Director 1', 2019 );"; 
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}