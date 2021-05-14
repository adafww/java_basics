public class Main {

  public static void main(String[] args) {
    Container container = new Container(7843);
    System.out.println(sumDigits(container.getCount()));
  }

  public static int sumDigits(Integer number) {
    int count = 0;
    if (number == null) {
      count = -1;
    }else {
      int lengthNumber = Integer.toString(number).length();
      String stringNumber = Integer.toString(number);
      for (Integer i = 0; i < lengthNumber; i++) {
        count += Character.getNumericValue(stringNumber.charAt(i));


      }
    }
    return count;
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */
}
