import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String htmlFile = parseFile("data/lenta_ru.html");
        Document doc = Jsoup.parse(htmlFile);
        List<String> strings = new ArrayList<>();
        List<String> names = new ArrayList<>();
        doc.select("img[src~=(?i)\\.(png|jpe?g|webp)]").stream().forEach(a -> strings.add(a.attr("abs:src")));
        strings.stream().forEach(b -> names.add(b.split("/")[b.split("/").length - 1]));
        for (int i = 0; i < strings.size(); i++){
            try {
                Connection.Response response = Jsoup.connect(strings.get(i)).ignoreContentType(true).execute();
                FileOutputStream out = new FileOutputStream("images/" + names.get(i));
                out.write(response.bodyAsBytes());
                out.close();
                System.out.println(names.get(i));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static String parseFile(String path){
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
