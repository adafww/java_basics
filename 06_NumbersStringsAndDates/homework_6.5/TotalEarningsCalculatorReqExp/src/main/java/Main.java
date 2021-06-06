public class Main {

  public static void main(String[] args) {

    System.out.println(calculateSalarySum("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей"));
  }

  public static int calculateSalarySum(String text){

    int result = 0;
    String[] digitCount = text.split("[,А-ЯЁа-яё\\s-]+\\s*");

    for (int i = 1; i < digitCount.length; i++){

      result += Integer.parseInt(digitCount[i]);
    }

    return result;
  }

}