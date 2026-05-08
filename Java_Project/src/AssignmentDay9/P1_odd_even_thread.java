package AssignmentDay9;

public class P1_odd_even_thread {

    static int num = 1;
    static final int MAX = 100;
    static final Object lock = new Object();

    public static void main(String[] args) {

        Thread odd = new Thread(() -> {
            while (num <= MAX) {
                synchronized (lock) {
                    if (num % 2 != 0) {
                        System.out.println("Odd: " + num);
                        num++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread even = new Thread(() -> {
            while (num <= MAX) {
                synchronized (lock) {
                    if (num % 2 == 0) {
                        System.out.println("Even: " + num);
                        num++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        odd.start();
        even.start();
    }
}