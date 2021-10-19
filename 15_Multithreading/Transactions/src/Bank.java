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
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        Account lowSyncAccount = null;
        Account topSyncAccount = null;
        if(Long.parseLong(fromAccount.getAccNumber()) > Long.parseLong(toAccount.getAccNumber())){
            lowSyncAccount = toAccount;
            topSyncAccount = fromAccount;
        }
        if(Long.parseLong(fromAccount.getAccNumber()) < Long.parseLong(toAccount.getAccNumber())){
            lowSyncAccount = fromAccount;
            topSyncAccount = toAccount;
        }
        if (!fromAccountNum.equals(toAccountNum) && fromAccount.getMoney() >= amount){
            boolean swchAmount;
            if(amount < 50_000){
                swchAmount = true;
            }else swchAmount = !isFraud(fromAccountNum, toAccountNum, amount);
            if(swchAmount){

                synchronized (lowSyncAccount){
                    synchronized (topSyncAccount){
                        accounts.put(fromAccount.getAccNumber(),
                                new Account(fromAccount.getMoney() - amount, fromAccount.getAccNumber()));
                        accounts.put(toAccount.getAccNumber(),
                                new Account(toAccount.getMoney() + amount, toAccount.getAccNumber()));
                    }
                }
            }else {
                synchronized (lowSyncAccount){
                    synchronized (topSyncAccount){
                        accounts.put(fromAccount.getAccNumber(),
                                new Account(BAN, fromAccount.getAccNumber()));
                        accounts.put(toAccount.getAccNumber(),
                                new Account(BAN, toAccount.getAccNumber()));
                    }
                }
            }
        }
    }

    public long getBalance(String accountNum) {

        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {return 0;}
}
