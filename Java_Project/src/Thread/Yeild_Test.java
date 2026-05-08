package Thread;
 
public class Yeild_Test extends Thread {
	public static void main(String[] args) {
		  Thread t1 = new Thread(() -> {
	            for (int i = 1; i <= 3; i++) {
	                System.out.println("Thread 1: " + i);
	               
	            }
	        });
	        Thread t2 = new Thread(() -> {
	            for (int i = 1; i <= 3; i++)
	                System.out.println("Thread 2: " + i);
	            Thread.yield();
	        });
	        t1.start();
	        t2.start();
	//When a thread calls yield(), it is telling the CPU:
 
//"I have a lot of work to do, but I'm not in a hurry. "
	        //"//If there are other threads waiting for a turn, I’m okay with "
// "//stepping back to the end of the line so they can run for a bit."        
 
	}
 
}