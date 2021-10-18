import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Hashtable<String, Account> accounts;
    private final Random random = new Random();
    private static final long BAN = -999_999_999;

    public Bank(Hashtable<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        if (!fromAccountNum.equals(toAccountNum) && accounts.get(fromAccountNum).getMoney() >= amount){
            boolean swchAmount;
            if(amount < 50_000){
                swchAmount = true;
            }else swchAmount = !isFraud(fromAccountNum, toAccountNum, amount);

            if(swchAmount){
                Account account = new Account();
                account.setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                account.setAccNumber(fromAccountNum);
                synchronized(accounts){
                    accounts.put(fromAccountNum, account);
                }
                account.setMoney(accounts.get(toAccountNum).getMoney() + amount);
                account.setAccNumber(toAccountNum);
                synchronized (accounts){
                    accounts.put(toAccountNum, account);
                }
            }else {
                Account accountBan = new Account();
                accountBan.setMoney(BAN);
                accountBan.setAccNumber(fromAccountNum);
                synchronized (accounts){
                    accounts.put(fromAccountNum, accountBan);
                }
                accountBan.setMoney(BAN);
                accountBan.setAccNumber(toAccountNum);
                synchronized (accounts){
                    accounts.put(toAccountNum, accountBan);
                }
            }
        }
    }

    public long getBalance(String accountNum) {

        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {return 0;}
}
