import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Date;

public class RedisStorage {
    // Объект для работы с Redis
    private RedissonClient redisson;

    // Объект для работы с ключами
    private RKeys rKeys;

    // Объект для работы с Sorted Set'ом
    private RScoredSortedSet<String> homePage;

    private final static String KEY = "ONLINE_USERS";

    private double getTs() {
        return new Date().getTime() / 1000;
    }

    // Пример вывода всех ключей
    public void listKeys() {
        Iterable<String> keys = rKeys.getKeys();
        for(String key: keys) {
            System.out.println("KEY: " + key + ", type:" + rKeys.getType(key));
        }
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        homePage = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    // Фиксирует посещение пользователем страницы
    void homePageVisit(int user_id)
    {
        //ZADD ONLINE_USERS
        homePage.add(getTs(), String.valueOf(user_id));
    }
    boolean homePageVisitTest(int user_id)
    {
        return Arrays.stream(homePage.stream().toArray()).filter(a -> a.equals(user_id)).toArray().length == 0;
    }

    void  justRemoveFirstUser(){
        homePage.remove(homePage.first());
    }
    int firstUser(){
        return Integer.parseInt(homePage.first());
    }
    int calculateUsersNumber()
    {
        //ZCOUNT ONLINE_USERS
        return homePage.count(Double.NEGATIVE_INFINITY, true, Double.POSITIVE_INFINITY, true);
    }
}
