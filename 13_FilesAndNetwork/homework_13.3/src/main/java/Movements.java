import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Movements {
    private static final String REX = "^([А-ЯЁа-яёA-Za-z0-9,. _+]+)([\\/A-Za-z0-9 _>|\\\\A-Za-z0-9 ]*[ ])([0-9. ]{17})([ 0-9.]+)(RUR|EUR|USD)([A-Za-z0-9 ,.()-]+|)(\\\"|)([0-9,]+|)(\\\"|)";
    private static HashMap<String, List<Double>> finalList = new HashMap<>();

    public Movements(String pathMovementsCsv) {
        try {
            List<String[]> strings = new ArrayList<>(getList(Files.readAllLines(Paths.get(pathMovementsCsv))));
            finalList = getBigList(strings);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private static List<String[]> getList(List<String> str){
        List<String[]> strings = new ArrayList<>();
        for (int i = 1; i < str.size(); i++){
            String[] str1 = Pattern.compile(REX)
                    .matcher(str.get(i))
                    .replaceAll("$2#$4#$5#$8")
                    .split("#");
            strings.add(str1);
        }
        return strings;
    }

    private static HashMap<String, List<Double>> getBigList(List<String[]> str){
        HashMap<String, List<Double>> list = new HashMap<>();
        for(int i = 0; i < str.size();i++){
            String name = str
                    .get(i)[0]
                    .replace("/", "")
                    .replace("\\", "")
                    .trim()
                    .toUpperCase();
            List<Double> doubles = new ArrayList<>();
            if(list.containsKey(name)){
                doubles = list.get(name);
            }
            if (str.get(i)[2].equals("RUR")){
                if (str.get(i)[0].trim().substring(0,1).equals("/")){
                    doubles.add(Double.parseDouble(str.get(i)[1].trim()));
                }else {
                    doubles.add(Double.parseDouble("-" + str.get(i)[1].trim()));
                }
            }else {
                if (str.get(i)[0].trim().substring(0,1).equals("/")){
                    doubles.add(Double.parseDouble(str.get(i)[3].replace(",", ".")));
                }else {
                    doubles.add(Double.parseDouble("-" + str.get(i)[3].replace(",", ".")));
                }
            }
            list.put(name, doubles);
        }
        return list;
    }

    public double getExpenseSum() {
        return Math.abs(finalList.entrySet()
                .stream()
                .flatMap(a -> a.getValue()
                .stream()
                .filter(b -> b < 0))
                .mapToDouble(Double::doubleValue)
                .sum());
    }

    public double getIncomeSum() {

        return finalList.entrySet()
                .stream()
                .flatMap(a -> a.getValue()
                .stream()
                .filter(b -> b > 0))
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public void getOrgExp(){
        System.out.println("Суммы расходов по организациям:");
        for (Map.Entry<String, List<Double>> entry:finalList.entrySet()){
            System.out.println(entry.getKey() + "\t\t" + Math.abs(entry.getValue().stream().filter(g -> g < 0).mapToDouble(Double::doubleValue).sum()) + " руб.");
        }
    }

}
