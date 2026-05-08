package AssignmentDay9;

class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit: " + amount + " Balance: " + balance);
    }
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw: " + amount + " Balance: " + balance);
        } else {
            System.out.println("Not enough balance");
        }
    }
}

public class P3_deposit_withdraw {

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        Thread t1 = new Thread() {
            public void run() {
                acc.deposit(500);
                acc.withdraw(700);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                acc.withdraw(800);
                acc.deposit(300);
            }
        };
        t1.start();
        t2.start();
    }
}