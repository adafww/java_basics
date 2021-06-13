public class Main {
    public static void main(String[] args) {

        char[][] result = TwoDimensionalArray.getTwoDimensionalArray(3);

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result[i].length; j++) {

                System.out.print(result[i][j] + "\t");
            }

            System.out.println();
        }
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
    }
}
