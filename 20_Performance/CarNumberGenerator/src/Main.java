import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(16);
        service.submit(new Loader(99));
        service.shutdown();
        if (service.awaitTermination(999999999, TimeUnit.SECONDS)){
            System.out.println((System.currentTimeMillis() - start) + " ms");
        }
    }
}
