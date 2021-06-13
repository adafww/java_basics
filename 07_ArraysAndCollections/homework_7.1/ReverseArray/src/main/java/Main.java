public class Main {

    public static void main(String[] args) {

        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] text = line.split(",?\\s");
        String[] reverseArray = ReverseArray.reverse(text);

        for (int i = 0; i < reverseArray.length; i++){

            System.out.println(reverseArray[i]);
        }
    }
}
