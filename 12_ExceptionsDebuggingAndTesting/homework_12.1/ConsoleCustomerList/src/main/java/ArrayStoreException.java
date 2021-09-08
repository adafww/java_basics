import java.util.Locale;

public class ArrayStoreException {

    ArrayStoreException()throws RuntimeException{

        Object x[] = new String[3];
        x[0] = new Integer(0);
    }
}
