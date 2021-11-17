import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.client.model.*;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import com.mongodb.Block;
import java.util.Scanner;
import org.bson.Document;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collectionMarkets = database.getCollection("marketsDb");
        MongoCollection<Document> collectionProducts = database.getCollection("productsDb");
        Scanner scanner = new Scanner(System.in);
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
        //collectionMarkets.drop();
        //collectionProducts.drop();
        //collectionProducts.deleteOne(new BasicDBObject(new Document("productName", "Вода").append("markets", new Document("marketName", "Магнит"))));
        while (true){
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("ВЫХОД") && input.length == 1) {
                break;
            }else if(input[0].equals("СТАТИСТИКА_ТОВАРОВ") && input.length == 1){
                String str3 = "$products_list.count";
                List cond = new ArrayList();
                cond.add(new BasicDBObject("$lt", Arrays.asList(str3, 100)));
                cond.add(1);
                cond.add(0);
                collectionMarkets.aggregate(Arrays.asList(
                        Aggregates.lookup("productsDb", "marketName", "markets", "products_list"),
                        Aggregates.unwind("$products_list"),
                        Aggregates.group("$marketName",
                                Accumulators.avg("avg", str3),
                                Accumulators.min("min", str3),
                                Accumulators.max("max", str3),
                                Accumulators.sum("count100",new BasicDBObject("$cond", cond)),
                                Accumulators.sum("count",1)
                        )
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

                String[] str;
                ArrayList<String> str1 = new ArrayList<>();
                if (0 != Integer.parseInt(String.valueOf(collectionProducts.count(Filters.eq("markets", input[1]))))){
                    str = (((JsonObject) JsonParser
                            .parseString(new Document(collectionProducts
                            .find(Filters.eq("productName", input[1]))
                            .first())
                            .toJson()))
                            .get("markets"))
                            .toString()
                            .split("\\[\\\"*, \"|\", \"|\"]");
                    str1 = (ArrayList<String>) Arrays.stream(str).collect(Collectors.toList());
                }
                Document query = new Document().append("productName",  input[1]);
                Document update = new Document();
                Document setData = new Document();
                str1.add(input[2]);
                setData.append("markets", str1);
                update.append("$set", setData);
                UpdateOptions options = new UpdateOptions().upsert(true);
                collectionProducts.updateOne(query, update, options);
                collectionProducts.find().forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
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
