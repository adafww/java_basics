public class Main {

  public static void main(String[] args) {
    Container container = new Container(7843);
    System.out.println(sumDigits(container.getCount()));
  }

  public static int sumDigits(Integer number) {
    int count = 0;
    for (Integer i = 0; i < Integer.toString(number).length(); i++ ){
      count += Character.getNumericValue(Integer.toString(number).charAt(i));
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
