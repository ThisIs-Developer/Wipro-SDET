package AssignmentDay9;

public class P2_abc_threadPrint {

    static int turn = 0;
    static final Object lock = new Object();
    static int times = 10;
    public static void main(String[] args) {
        Thread tA = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                synchronized (lock) {
                    while (turn != 0) {
                        try { lock.wait(); } catch (Exception e) {}
                    }
                    System.out.print("A");
                    turn = 1;
                    lock.notifyAll();
                }
            }
        });
        Thread tB = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                synchronized (lock) {
                    while (turn != 1) {
                        try { lock.wait(); } catch (Exception e) {}
                    }
                    System.out.print("B");
                    turn = 2;
                    lock.notifyAll();
                }
            }
        });
        Thread tC = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                synchronized (lock) {
                    while (turn != 2) {
                        try { lock.wait(); } catch (Exception e) {}
                    }
                    System.out.print("C ");
                    turn = 0;
                    lock.notifyAll();
                }
            }
        });
        tA.start();
        tB.start();
        tC.start();
    }
}