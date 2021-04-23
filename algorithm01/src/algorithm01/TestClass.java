package algorithm01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
public class TestClass {

	public static void main(String[] args) {
		 HashMap<Integer, Integer> map = new HashMap<>();
		 map.put(1, 12);
		 map.put(2, 22);
		 map.put(3, 32);
		 map.put(7, 72);
	        
//		 System.out.println(map.containsKey(3));
//		 System.out.println(map.containsValue(10+2));
//		 Iterator<Integer> it = map.values().iterator();
//		 while(it.hasNext()) {
//			 System.out.println(it.next());
//		 }
//		 PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
//		 priorityQueue.add(33);
//		 priorityQueue.add(77);
//		 priorityQueue.add(11);
//		 Iterator<Integer> it1 = priorityQueue.iterator();
//		 while(it1.hasNext()) {
//			 System.out.println(it1.next());
//		 }
		 
		 Stack<Integer> s = new Stack<>(); 
		 s.add(1);
		 s.add(2);
		 s.add(3);
		 System.out.println(s.peek());
		 System.out.println(s.peek());
		 System.out.println(s.pop());
		 System.out.println(s.peek());
	}

}
