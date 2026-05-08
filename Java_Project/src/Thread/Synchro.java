package Thread;
 
public class Synchro extends Thread {
	int count=0;
	synchronized void count()
	{
		count++;
	}
 
	public static void main(String[] args) {
		Synchro t1=new Synchro();
		t1.count();
		Synchro t2=new Synchro();
		t2.count();
 
	}
 
}