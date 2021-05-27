public class Main {

  public static void main(String[] args) {

    String text = "Over recent years there has been a proliferation of major video-game releases offering, enabling players to capture memorable moments on their adventures with their own in-game snaps.";
    System.out.println(splitTextIntoWords(text));
  }

  public static String splitTextIntoWords(String text) {

    int[] digitCount = new int[text.length()];
    boolean countSwitch = false;
    int count = 0;
    String result = "";
    String addString;

    for (int i = 0; i < text.length(); i++){

      if(!countSwitch && Character.toString(text.charAt(i)).matches("[a-zA-Z’]")){

        digitCount[count] = i;
        count++;
        countSwitch = true;
      }

      if(countSwitch && !Character.toString(text.charAt(i)).matches("[a-zA-Z’]")){

        digitCount[count] = i;
        count++;
        countSwitch = false;
      }
    }

    int[] stringCount = new int[count];

    for (int i = 0; i < stringCount.length; i++ ) {

      addString = text.substring(digitCount[i], digitCount[++i]);

      if (!addString.matches(" ")) {

        if (i != stringCount.length - 1){

          result += (addString + "\n");
        }else {

          result += (addString);
        }
      }
    }

    return result;
  }

}