public class Main {

  public static void main(String[] args) {

    System.out.println(calculateSalarySum("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей"));
  }

  public static int calculateSalarySum(String text){

    int[] digitCount = new int[text.length()];
    boolean countSwitch = false;
    int count = 0;
    int result = 0;

    for (int i = 0; i < text.length(); i++){

      if(!countSwitch && Character.toString(text.charAt(i)).matches("[0-9]")){

        digitCount[count] = i;
        count++;
        countSwitch = true;
      }

      if(countSwitch && !Character.toString(text.charAt(i)).matches("[0-9]")){

        digitCount[count] = i;
        count++;
        countSwitch = false;
      }
    }

    for (int i = 0; i < digitCount.length; i++ ){

      if (digitCount[i] != 0) {

        result += Integer.parseInt(text.substring(digitCount[i], digitCount[++i]));
      }
    }

    return result;
  }

}