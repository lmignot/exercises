package BankAccount;

/**
 * Day 17 exercise 3
 */
public class Atm implements Runnable {

    private static final int START_BALANCE = 0;
    private static final int WITHDRAWAL = 10;
    private static final int DEPOSIT = 20;

    private BankAccount b;

    public Atm (BankAccount acct) {
        this.b = acct;
    }

    public static void main (String[] args) {
        BankAccount b = new BankAccount();
        for(int i = 0; i < 100; i++) {
            Atm atm = new Atm(b);
            Thread t = new Thread(atm);
            t.start();
        }
    }

    @Override
    public void run() {
        b.deposit(START_BALANCE);
        System.out.println("Start balance " + b.getBalance());
        for (int i = 0; i < 1000; i++) {
            if(i % 2 == 0) {
                System.out.println("Iteration: "+i+" Balance before deposit " + b.getBalance());
                b.deposit(DEPOSIT);
                System.out.println("Balance after deposit " + b.getBalance());
            } else {
                System.out.println("Iteration: "+i+" Balance before withdrawal " + b.getBalance());
                int ret = b.retrieve(WITHDRAWAL);
                System.out.println("Withdrew " + ret);
                System.out.println("Balance after withdrawal " + b.getBalance());
            }
        }
        System.out.println("Final balance " + b.getBalance());
    }
}
