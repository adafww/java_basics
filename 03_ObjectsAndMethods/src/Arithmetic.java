public class Arithmetic {

    public double result;

    public void addition (double a, double b){
        double result = a + b;
        System.out.println("Сумма чисел: "+ result);
    }

    public void subtraction (double a, double b){
        double result = a - b;
        System.out.println("Разность чисел: "+ result);
    }

    public void multiplication (double a, double b) {
        double result = a * b;
        System.out.println("Произведения чисел: " + result);
    }

    public void middle (double a, double b) {
        double result = (a + b) / 2;
        System.out.println("Среднее значение чисел: " + result);
    }

    public void max (double a, double b) {
        double result = Math.max(a, b);
        System.out.println("Максимальное из двух чисел: " + result);
    }

    public void min (double a, double b) {
        double result = Math.min(a, b);
        System.out.println("Минимальное из двух чисел: " + result);
    }
}
