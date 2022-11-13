package sqljdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

public class sqlconnect {

   public static void main(String[] args){
  try {
      
	//  Class.forName("com.mysql.cj.jdbc.Driver");
	   
      String url = "jdbc:mysql://localhost:3306/jdbc";
      String user = "sqljdbc";
      String password = "praj@123";

      //Create connection
      Connection coll = DriverManager.getConnection(url, user, password);

      //JDBC statement object
      Statement stmt = coll.createStatement();

      Scanner sc = new Scanner(System.in);
    
      while(true) {
         System.out.println("Menu:\n"
         		+ "1)Insert\n"
         		+ "2)Update\n"
         		+ "3)Delete\n"
         		+ "4)Exit");
         System.out.print("Enter Choice: ");
         int op = sc.nextInt();

         switch (op) {
            case 1:
               System.out.println("Insert:");
               
               System.out.println("Enter RollNo.: ");
               int rollno= sc.nextInt();
               
               System.out.println("Enter Name: ");
               String name= sc.next();
              
               System.out.println("Enter Dept: ");
               String dept= sc.next();
              
               System.out.println("Enter Email: ");
               String email= sc.next();
               
               String query = "INSERT INTO Students VALUES(" + rollno + ",\"" + name  + "\",\"" + dept + "\",\"" + email +  "\");";
               System.out.println(query);
               
               try {
                  int excp = stmt.executeUpdate(query);
                  System.out.println(excp);

               } catch (Exception e) {
                  System.out.println(e);
               }
               break;

            case 2:
               System.out.println("Update Operation-->");
               System.out.print("Enter column to update: ");
               String colname = sc.next();
               
               System.out.print("Enter New Value: ");
               String change = sc.next();
               
               System.out.print("Enter Condition: ");
               String cndn = sc.next();

               String query1 = "UPDATE Students SET " + colname + "=" + "\""+change+"\""+  " WHERE " + cndn + ";";

               try {
                  int excp = stmt.executeUpdate(query1);
                  System.out.println(excp);

               } catch (Exception e)
               {
                  System.out.println(e);
               }
               break;

            case 3:
               System.out.println("Delete Operation-->");
               System.out.print("Enter Condition: ");
               String cndn1 = sc.next();
               
               String query2 = "DELETE FROM students WHERE " + cndn1 + ";";
               
               try {
                  int excp = stmt.executeUpdate(query2);
                  System.out.println(excp);

               } catch (Exception e) 
               {
                  System.out.println(e);
               }
               break;

            case 4:
               stmt.close();
               //close connection
               coll.close();
               System.exit(0);
               break;
            default:
               System.out.println("Enter Correct option !!");
         }
      }
   }catch(Exception e)
   {
	   e.printStackTrace();
   }
  }
}
