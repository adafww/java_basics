public class Main {

  public static void main(String[] args) {

    int firstNumber = 0;
    int zeroCount = 0;
    int ifCount = 0;
    int textSum = 0;
    String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    for (int i = 0; i < alphabet.length(); i++){
        System.out.println(alphabet.charAt(i) + ": " + (int) alphabet.charAt(i));
    }

    // Программа будет работать при смене имен и цифр
    for (int i = 0; i < text.length(); i++){
      if (Character.toString(text.charAt(i)).equals(" ")){
        zeroCount++;
      }
      if (zeroCount == 2 && ifCount == 0){
          firstNumber = ++i;
          ifCount++;
      }
      if (zeroCount == 3 && ifCount == 1 ){
        textSum += Integer.parseInt(text.substring(firstNumber, i));
        ifCount++;
      }
      if (zeroCount == 6 && ifCount == 2){
        firstNumber = ++i;
        ifCount++;
      }
      if (zeroCount == 7 && ifCount == 3 ){
        textSum += Integer.parseInt(text.substring(firstNumber, i));
        ifCount++;
      }
      if (zeroCount == 11 && ifCount == 4){
        firstNumber = ++i;
        ifCount++;
      }
      if (zeroCount == 12 && ifCount == 5 ){
        textSum += Integer.parseInt(text.substring(firstNumber, i));
        System.out.println(textSum);
        ifCount++;
      }
    }
  }
}