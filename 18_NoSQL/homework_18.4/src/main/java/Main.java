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

import java.awt.image.LookupOp;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;

public class Main {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collectionMarkets = database.getCollection("marketsDb");
        MongoCollection<Document> collectionProducts = database.getCollection("productsDb");
        //MongoCollection<Document> collection = database.getCollection("db_18_1");
        Scanner scanner = new Scanner(System.in);
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };

        //collectionMarkets.drop();
        //collectionProducts.drop();
        //collectionProducts.deleteOne(new BasicDBObject(new Document("productName", "Вода")
         //       .append("markets", new Document("marketName", "Магнит"))));

        while (true){
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("ВЫХОД") && input.length == 1) {
                break;
                //СТАТИСТИКА_ТОВАРОВ
            }else if(input[0].equals("") && input.length == 1){
                collectionMarkets.aggregate(Arrays.asList(
                        //match(eq("marketName", "Магнит")),
                        lookup("productsDb", "marketName", "markets", "products_list")
                        //out("products")
                )).forEach(printBlock);
            }else if(input[0].equals("1") && input.length == 1){
                collectionProducts.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
            }else if(input[0].equals("2") && input.length == 1){
                collectionMarkets.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
            }else if(input[0].equals("ВЫСТАВИТЬ_ТОВАР") && input.length == 3){
                collectionProducts.insertOne(
                        new Document("productName", input[1])
                                .append("markets", new Document("marketName", input[2]))
                );
                collectionProducts.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
                //ВЫСТАВИТЬ_ТОВАР Вода Магнит
            }else if(input[0].equals("ДОБАВИТЬ_ТОВАР") && input.length == 3){
                collectionProducts.insertOne(new Document()
                        .append("productName", input[1])
                        .append("count", Integer.parseInt(input[2]))
                );
                collectionProducts.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
            }else if(input[0].equals("ДОБАВИТЬ_МАГАЗИН") && input.length == 2){
                collectionMarkets.insertOne(new Document("marketName", input[1]));
                collectionMarkets.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
            }
        }
    }
}
