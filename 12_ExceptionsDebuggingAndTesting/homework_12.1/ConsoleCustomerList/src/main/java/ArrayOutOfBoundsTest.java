import java.util.Arrays;

public class ArrayOutOfBoundsTest {

    ArrayOutOfBoundsTest(int number) throws RuntimeException{

        int[] n = new int[2];
        for (int i = 0; i <= number; i++){

            n[i] = 1;
        }
    }
}
