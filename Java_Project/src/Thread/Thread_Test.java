package Thread;

public class Thread_Test extends Thread {
	public void run() {
		for(int i=0;i<=3;i++)
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignored) {
			// TODO Auto-generated catch block
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread_Test t0 = new Thread_Test();
		Thread_Test t1 = new Thread_Test();
		Thread_Test t2 = new Thread_Test();
		
//		System.out.println("Before Priority: "+t1.getPriority());
//		t1.setPriority(2);
//		System.out.println("After Priority: "+t1.getPriority());
//		System.out.println("Before name: "+t2.getName());
//		t2.setName("Baivab2");
//		t1.setName("Sarkar1");
//		t0.setName("BS0");
//		System.out.println("After name: "+t2.getName());
//		t0.start();
//		t1.start();
//		t1.sleep(1000);
//		t2.start();
		
		t0.start();
		t2.join();
		t1.start();
		t2.start();
	}

}
