package jdbcMongo;

import com.mongodb.*;

public class Update {
    
	public static void main(String[] args)
	{
	
		//create a connection
		MongoClient mongo = new MongoClient("localhost",27017);
				
		//create a database
		DB db = mongo.getDB("jdbc");
				
		//create a collection
		DBCollection cltn= db.getCollection("Assi12");
		
    //Update Queries
		BasicDBObject oldDoc = new BasicDBObject("name","simon").append("age", 25);
		BasicDBObject newDoc = new BasicDBObject("name","ayush").append("age",21);
		BasicDBObject updateDoc = new BasicDBObject("$set",newDoc);
		
		cltn.update(oldDoc,updateDoc);
		
		//display doc
		DBCursor pin = cltn.find();
				
		while(pin.hasNext())
		{
			System.out.println(pin.next());
		}
		
	}
}
