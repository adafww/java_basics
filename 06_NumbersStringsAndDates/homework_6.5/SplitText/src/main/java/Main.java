public class Main {

  public static void main(String[] args) {

    String text = "Over recent years there has been a proliferation of major video-game releases offering, enabling players to capture memorable moments on their adventures with their own in-game snaps.";
    System.out.println(splitTextIntoWords(text));
  }

  public static String splitTextIntoWords(String text) {

    String result = "";
    String[] digitCount = text.split("[^’A-Za-z]+");

    for (int i = 0; i < digitCount.length; i++){

      if (i == digitCount.length - 1){
        result += digitCount[i];
      }

      if (i < digitCount.length - 1){
        result += digitCount[i] + System.lineSeparator();
      }

      System.out.println(digitCount[i]);
    }

    return result;
  }

}