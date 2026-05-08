package AssignmentDay9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class P4_delivery_threadpool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            int orderId = i;
            pool.execute(() -> {
                System.out.println("Order " + orderId + " by " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (Exception e) {}
            });
        }
        pool.shutdown();
    }
}