import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {

    private static final int SLEEP = 1000;
    private static final int MAX_USERS_ON_HOMEPAGE = 10;
    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    private static void log(int UsersOnline) {
        String log = String.format("[%s] На главной странице показываем пользователя: %d", DF.format(new Date()), UsersOnline);
        System.out.println(log);
    }
    private static void log1(int UsersOnline) {
        String log = String.format("[%s] Пользователь %d оплатил платную услугу", DF.format(new Date()), UsersOnline);
        System.out.println(log);
    }
    private static void log2(int UsersOnline) {
        String log = String.format("[%s] Пользователь %d удален с главной страницы", DF.format(new Date()), UsersOnline);
        System.out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {
        RedisStorage redis = new RedisStorage();
        redis.init();
        int i = 1;
        while (true){
            int random = new Random().nextInt(10);
            if(random == 0 && random != i && redis.homePageVisitTest(random)){
                int user_id = new Random().nextInt(1000);
                log1(user_id);
                log(user_id);
                redis.homePageVisit(user_id);
            }else {
                log(i);
                redis.homePageVisit(i);
                i++;
            }
            while (redis.calculateUsersNumber() > MAX_USERS_ON_HOMEPAGE){
                redis.justRemoveFirstUser();
                log2(redis.firstUser());

            }
            Thread.sleep(SLEEP);
        }
    }
}
