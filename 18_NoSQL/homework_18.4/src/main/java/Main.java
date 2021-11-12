import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = database.getCollection("dbMarkets");
        Scanner scanner = new Scanner(System.in);
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };

        //collection.drop();

        while (true){
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("ВЫХОД") && input.length == 1) {
                break;
            }else if(input[0].equals("СТАТИСТИКА_ТОВАРОВ") && input.length == 1){
                collection.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
                System.out.println("-------------------");
                collection.aggregate(
                        Arrays.asList(
                                Aggregates.match(Filters.eq("marketName", "Пятёрочка")),
                                Aggregates.group("$connection", Accumulators.sum("count", 1))
                                /*
                                Aggregates.project(
                                        Projections.fields(
                                                Projections.excludeId(),
                                                Projections.include("productName"),
                                                Projections.computed(
                                                        "aaa",
                                                        new Document("products", 0)
                                                )
                                        )
                                )
                                */
                        )
                ).forEach(printBlock);

            }else if(input[0].equals("ВЫСТАВИТЬ_ТОВАР") && input.length == 3){
                collection.insertOne(new Document("connection", new Document()
                        .append("productName", input[1])
                        .append("marketName", input[2])
                ));
                collection.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });

            }else if(input[0].equals("ДОБАВИТЬ_ТОВАР") && input.length == 3){
                collection.insertOne(new Document("products", new Document()
                        .append("productName", input[1])
                        .append("count", Integer.parseInt(input[2]))
                ));
                collection.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
            }else if(input[0].equals("ДОБАВИТЬ_МАГАЗИН") && input.length == 2){
                collection.insertOne(new Document("markets", new Document("marketName", input[1])));
                collection.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
            }
        }
    }
}
