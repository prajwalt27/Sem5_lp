package jdbcMongo;

import com.mongodb.*;

public class Create {

	public static void main(String[] args) {
		//create a connection
		
		MongoClient mongo = new MongoClient("localhost",27017);
		
		//create a database
		DB db = mongo.getDB("jdbc");
		
		//create a collection
		DBCollection cltn= db.getCollection("Assi12");
		
		//insert a document
		
		//create a db object
		BasicDBObject d1= new BasicDBObject("roll","101").append("name","prajwal").append("age",20);
		BasicDBObject d2= new BasicDBObject("roll","102").append("name","shreyas").append("age",20);
		BasicDBObject d3= new BasicDBObject("roll","103").append("name","praneeth").append("age",21);
		BasicDBObject d4= new BasicDBObject("roll","104").append("name","kaushik").append("age",20);
		BasicDBObject d5= new BasicDBObject("roll","105").append("name","tanmay").append("age",20);
		BasicDBObject d6= new BasicDBObject("roll","106").append("name","simon").append("age",25);

    //insert in collection
		cltn.insert(d1,d2,d3,d4,d5,d6);
		
		
		//display doc
		DBCursor pin = cltn.find();
		
		while(pin.hasNext())
		{
			System.out.println(pin.next());
		}
	}

}
