package mjdbc;
import com.mongodb.*;
import java.util.Scanner;
import org.bson.Document;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class mongoconnect {

	public static void main(String[] args) {
		String  value, roll,name,dept;
		
		Scanner sc = new Scanner(System.in);
		
		int choice ;
		
		try {
			MongoClient mongo=new MongoClient("localhost",27017);
			
			MongoDatabase db= mongo.getDatabase("mock");
			
			MongoCollection coll= db.getCollection("jdbc");
			
			do {
				System.out.println("*** Menu ***\n"+
				  "1. Insert \n"+
			    "2. Update \n"+
			    "3. Delete \n"+
			    "4. Display \n"+
		      "5. Exit");
				System.out.println("Enter your choice: ");
				choice= sc.nextInt();
				
				switch(choice) {
				
				case 1:
					Document d= new Document();
				    
					System.out.println("Enter rollno: ");
					sc.nextLine();
					roll=sc.nextLine();
					d.put("rollno",roll);
					
					System.out.println("Enter name: ");
					name=sc.nextLine();
					d.put("name", name);
					
					System.out.println("Enter dept: ");
					dept= sc.nextLine();
					d.put("dept",dept);
										
	     			coll.insertOne(d);
					break;
				
				case 2:
					Document u= new Document();
					
					System.out.println("Enter roll no. which you to update: ");
					value=sc.nextLine();
					u.put("rollno",value);
					
					Document d1= new Document();
					d1.put("rollno", value);
					
					System.out.println("Enter name: ");
					name=sc.nextLine();
					d1.put("name",name);
					
					System.out.println("Enter dept: ");
					dept=sc.nextLine();
					d1.put("dept", dept);
					
					coll.replaceOne(u,d1);
					break;
				
				case 3:
					System.out.println("Enter rollno want to delete: ");
					value= sc.nextLine();
					Document r= new Document();
					
					r.put("roll",value);
					coll.deleteOne(r);
					break;
					
				case 4:
					MongoCursor cd= coll.find().cursor();
					
					if(!cd.hasNext())
					{
						System.out.println("\n Empty Database!\n");
					}
					while(cd.hasNext())
					{
						System.out.println(cd.next());
					}
				     break;
				 
				case 5:
					System.exit(0);
					break;    
			 }
			} while(choice!=5);
		}
     catch(MongoException e) 
     {
			 e.printStackTrace();
		 }
	}

}
