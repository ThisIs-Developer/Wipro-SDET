package Collection;

import java.util.PriorityQueue;

public class PriorityQueue_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> pq = new PriorityQueue<String>();
		PriorityQueue<Integer> arr = new PriorityQueue<Integer>();
		
		pq.add("Kolkata");
		pq.add("Up");
		pq.add("kolkata");
		pq.add("KOKATA");
		pq.add("up");
		pq.add("UP");
		pq.add("Ayodha");
		pq.add("Allepey");
		
		arr.add(43);
		arr.add(34);
		arr.add(74);
		arr.add(34);
		arr.add(56);
		arr.add(12);
		arr.add(63);
		
		System.out.println("Str: "+pq);
		System.out.println("Int: "+arr);
		
//		pq.offer("Mumbai1");
//		System.out.println("Str: "+pq);
		System.out.println(arr.peek());
		System.out.println(arr.poll());
		
		
		
	}

}
