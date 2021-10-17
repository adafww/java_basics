import java.util.Hashtable;

public class Generator implements Runnable {

    @Override
    public void run() {
        Hashtable<String, Account> accounts = new Hashtable<>();
        for(int i = 0; i < 1_000_000; i++){
            String str = Integer.toString(i);
            accounts.put(str, new Account((1 + (long)(Math.random() * ((1_000_000 - 1) + 1))), str));
        }
        Bank bank = new Bank(accounts);
        for (int e = 0; e < 1000000; e++){
            String from = Long.toString(1 + (long)(Math.random() * ((1_000_000 - 1) + 1)));
            String to = Long.toString(1 + (long)(Math.random() * ((1_000_000 - 1) + 1)));
            try {
                bank.transfer(
                        from,
                        to,
                        (1 + (long)(Math.random() * ((100000 - 1) + 1)))
                );
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("from: " + bank.getBalance(from) + " - to: " + bank.getBalance(to));
        }
    }
}
