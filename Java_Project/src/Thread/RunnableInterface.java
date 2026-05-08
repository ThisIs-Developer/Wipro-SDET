package Thread;

public class RunnableInterface implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<3;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableInterface r1 = new RunnableInterface();
		r1.run();
		RunnableInterface r2 = new RunnableInterface();
		r2.run();
		System.out.println(r1.equals(r2));
	}

	

}
