import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static FileUtils fileUtils = new FileUtils();

    public static void main(String[] args) {

        System.out.println("Введите путь до папки:");
        Scanner scanner = new Scanner(System.in);
        for (;;){
            String input = scanner.nextLine();
            System.out.println("Размер папки " + input + " " + size(fileUtils.calculateFolderSize(input)));
        }
    }
    public static String size(long size) {
        String unit = " bytes";
        if (size > 1024) {
            size = size / 1024;
            unit = " kb";
        }
        if (size > 1024) {
            size = size / 1024;
            unit = " mb";
        }
        if (size > 1024) {
            String str1 = Long.toString(size);
            String str2 = str1.substring(str1.length() - 3, str1.length() - 1);
            size = size / 1024;
            unit = "." + str2 + " gb";
        }
        return size + unit;
    }
}
