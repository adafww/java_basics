import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        CountingBoxes(boxes);
    }
    public static void CountingBoxes(String boxes){
        int boxCount = Integer.parseInt(boxes);
        int containerCount = 0;
        int trackCount = 0;
        int countForBox = 1;
        int countForContainer = 1;
        if(boxCount > 0) {
            if(boxCount == 27) {
                containerCount = 1;
            }else {
                containerCount = boxCount % 27 == 0 ? boxCount % 27 : boxCount / 27 + 1;
            }
        }
        if (containerCount > 0){
            trackCount = containerCount % 12 == 0 ? containerCount % 12 : containerCount / 12 + 1;
        }
        for (int a = 1; a <= trackCount; a++){
            System.out.println("Грузовик: " + a);
            for (int b = 1; b <= 12 && countForContainer <= containerCount; b++){
                System.out.println("\tКонтейнер: " + countForContainer);
                countForContainer++;
                for (int c = 1; c <= 27 && countForBox <= boxCount; c++){
                    System.out.println("\t\tЯщик: " + countForBox);
                    countForBox++;
                }
            }
        }
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + trackCount + " шт.");
        System.out.println("контейнеров - " + containerCount + " шт.");
    }
}
