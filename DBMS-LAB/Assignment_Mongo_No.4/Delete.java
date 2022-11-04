package jdbcMongo;

import com.mongodb.*;


public class Delete {

	public static void main(String[] args) {
		
		//create a connection
		MongoClient mongo = new MongoClient("localhost",27017);
						
		//create a database
		DB db = mongo.getDB("jdbc");
						
		//create a collection
		DBCollection cltn= db.getCollection("Assi12");
		
		//Delete Queries
		BasicDBObject d= new BasicDBObject("age",20);
		cltn.remove(d);
		//display doc
		DBCursor pin = cltn.find();
						
		while(pin.hasNext())
		{
			System.out.println(pin.next());
		}
	}

}
