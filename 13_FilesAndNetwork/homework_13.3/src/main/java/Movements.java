import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Movements {
    private static final String REX = "([А-ЯЁа-яё ]{12})(,)([0-9]{20})(,)([A-Z]{3})(,)([0-9.]{8})(,)([A-Z_0-9]*)(,)([0-9+]{16})([ ]*)([A-Z0-9]*|)([A-Za-z0-9 _>/\\\\]*)([0-9.]{8})( )([0-9.]{8})([ ]*)([0-9.]*)([ ]*)([A-Z]{3})( )([A-Za-z0-9- )(]*)(,)([0-9,]*)(\\\"|)([0-9]*|)(,|)([0-9]*|)(\\\"|)";
    private static final double euroExchangeRate = 85.27;
    private static final double dollarExchangeRate = 72.53;
    private static HashMap<String, List<Double>> list = new HashMap<>();

    public Movements(String pathMovementsCsv) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            List<String[]> strings = new ArrayList<>();
            for (int i = 1; i < lines.size(); i++){
                String[] str = Pattern.compile(REX)
                        .matcher(lines.get(i))
                        .replaceAll("$14#$19#$21#$25$27$29")
                        .split("#");
                strings.add(str);
            }
            for(int i = 0; i < strings.size();i++){
                String name = strings.get(i)[0].replace("/", "").replace("\\", "").trim().toUpperCase();
                double income;
                double expense;
                List<Double> doubles = new ArrayList<>();
                if(strings.get(i)[2].equals("RUR")){
                    income = Double.parseDouble(strings.get(i)[1].replace(",", "."));
                    expense = Double.parseDouble("-" + strings.get(i)[3].replace(",", "."));
                }else if(strings.get(i)[2].equals("EUR")){
                    income = euroExchangeRate * Double.parseDouble(strings.get(i)[1].replace(",", "."));
                    expense = euroExchangeRate * Double.parseDouble("-" + strings.get(i)[3].replace(",", "."));
                }else if(strings.get(i)[2].equals("USD")){
                    income = dollarExchangeRate * Double.parseDouble(strings.get(i)[1].replace(",", "."));
                    expense = dollarExchangeRate * Double.parseDouble("-" + strings.get(i)[3].replace(",", "."));
                }else {
                    throw new Exception("Неизвестная валюта");
                }
                if(list.containsKey(name)){
                    doubles = list.get(name);
                }
                doubles.add(income);
                doubles.add(expense);
                list.put(name, doubles);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //list.entrySet().stream().flatMap(a -> a.getValue().stream()).forEach(System.out::println);

    }
    public double getExpenseSum() {
        return Math.abs(list.entrySet()
                .stream()
                .flatMap(a -> a.getValue()
                .stream()
                .filter(b -> b < 0))
                .reduce((c1, c2) -> c1 + c2).get());
    }

    public double getIncomeSum() {
        return list.entrySet()
                .stream()
                .flatMap(a -> a.getValue()
                .stream()
                .filter(b -> b > 0))
                .reduce((c1, c2) -> c1 + c2).get();
    }

    public void getOrgExp(){
        System.out.println("Суммы расходов по организациям:");
        for (Map.Entry<String, List<Double>> entry:list.entrySet()){
            System.out.println(entry.getKey() + "\t\t" + new DecimalFormat("#0.00").format(Math.abs(entry.getValue().stream().filter(a -> a < 0).reduce((b1, b2) -> b1 + b2).get())) + " руб.");
        }
    }

}
