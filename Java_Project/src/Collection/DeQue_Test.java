package Collection;
import java.util.ArrayDeque;
import java.util.Deque;

public class DeQue_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> dq = new ArrayDeque<String>();
		
		dq.add("Kolkata");
		dq.add("Mumbai");
		dq.add("Delhi");
		dq.add("Pune");
		dq.add("Ayodha");
		dq.add("Allepey");
		
		System.out.println(dq);
		System.out.println(dq.getFirst());
		System.out.println(dq.getLast());
		
		System.out.println(dq.offer("Goa"));
		System.out.println(dq);
		System.out.println(dq.offerFirst("JK"));
		System.out.println(dq);
		System.out.println(dq.offerLast("UP"));
		System.out.println(dq);
		
		System.out.println(dq);
		System.out.println("Peek: "+dq.peekFirst());
		System.out.println(dq);
		System.out.println("Peek: "+dq.peekLast());
		
		System.out.println(dq);
		System.out.println("Pull: "+dq.poll());	
		System.out.println(dq);
		System.out.println("Pull: "+dq.pollFirst());
		System.out.println(dq);
		System.out.println("Pull: "+dq.pollLast());
		
		System.out.println(dq);
		System.out.println("Pull: "+dq.pop());	
		System.out.println(dq);
	}

}
