import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static FileUtils fileUtils = new FileUtils();

    public static void main(String[] args) {

        System.out.println("Введите путь до папки:");
        scanner = new Scanner(System.in);
        for(;;){
            try {
                System.out.println(fileUtils.calculateFolderSize(scanner.nextLine()) / (1024 * 1024) + " mb");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
