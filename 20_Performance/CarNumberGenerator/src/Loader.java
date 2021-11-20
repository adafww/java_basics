import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Loader implements Runnable {

    private int regionCount;
    private static char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    Loader(int regionCount){
        this.regionCount = regionCount;
    }

    @Override
    public void run() {

        for (int regionCode = 1; regionCode <= regionCount; regionCode++){
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("res/numbers_of_" + regionCode + "_regions.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            StringBuilder builder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append("\n");
                        }
                    }
                }
            }
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        }
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder builder = new StringBuilder();
        builder.append(number);
        if(builder.length() == numberLength){
            return builder.toString();
        }else if(builder.length() == numberLength - 1){
            return '0' + builder.toString();
        }else if(builder.length() == 1 && numberLength == 3){
            return '0' + '0' + builder.toString();
        }
        return "----";
    }
}
