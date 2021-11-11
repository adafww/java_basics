import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;

import com.mongodb.DBCursor;
import com.mongodb.client.*;

import com.opencsv.CSVReader;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.FileReader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("local");

        MongoCollection<Document> collection = database.getCollection("Students");

        collection.drop();

        List<Document> studentDoc = new ArrayList<>();
        String csvFilename = "data/mongo.csv";
        String[] csvRow = null;

        collection.drop();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(csvFilename));

            List<String[]> csvAllRows = csvReader.readAll();
            for (Object object : csvAllRows) {
                csvRow = (String[]) object;
                studentDoc.add(new Document()
                        .append("name", csvRow[0])
                        .append("age", Integer.parseInt(csvRow[1]))
                        .append("courses", csvRow[2])
                );
            }
        } catch (Exception e) {
                System.out.println("exception :" + e.getMessage());
                }
        collection.insertMany(studentDoc);

        System.out.println("Number of students: " + collection.count());

        BasicDBObject query1 = new BasicDBObject("age", new BasicDBObject("$gt", 40));
        System.out.println("Number of students over 45 years old: " + collection.count(query1));

        System.out.println("Youngest student:");
        BasicDBObject query2 = new BasicDBObject("age", 1);
        System.out.println(new Document(collection.find().sort(query2).first()).toJson());

        System.out.println("Oldest student's courses:");
        BasicDBObject query3 = new BasicDBObject("age", -1);
        System.out.println(((JsonObject) JsonParser.parseString(new Document(collection.find().sort(query3).first()).toJson())).get("courses"));
    }
}
