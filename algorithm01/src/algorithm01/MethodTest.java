package algorithm01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
public class MethodTest {

	public static void main(String[] args) {
		// TreeMap : 키값에따라 자동 정렬됨
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		// 해쉬맵 ----------------------------------------------
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 12);
		map.put(2, 22);
		map.put(3, 32);
		map.put(7, 72);
		boolean findKey = map.containsKey(3);	// 해당 키를 가진객채 있는지 
		boolean findValue = map.containsValue(10+2);	// 해당 키를 가진객채 있는지 
		System.out.println(findKey);
		System.out.println(findValue);
		
		// 자바의 컬렉션 프레임워크는 컬렉션에 저장된 요소를 읽어오는 방법을 Iterator 인터페이스로 표준화
//		Iterator<Integer> it = map.values().iterator();	// Map의 value를 Iterator로 반환, key는 map.key().iterator()
//		Iterator<Integer> keys = map.keySet().iterator();	// Map의 Key를 
		// key, value 얻어오는 방법 1 람다식
		map.forEach((k,v) -> System.out.println("key : " + k + ", value : " + v));
		// key, value 얻어오는 방법 2 Entry를 이용한  for문
//		for(Entry<Integer, Integer> entry : map.entrySet()){
//			System.out.println("key : " + entry.getKey() + " , value : " + entry.getValue());
//		}
		// hasNext() : 읽어 올 요소가 남아있는지 확인 있으면 true 없으면 false
//		while(it.hasNext()) {
			// next() : 
//			System.out.println(it.next());
			// it.remove() : next()로 읽어 온 요소 삭제. next() 호출 한 다음 호출해야 함
//		}
		// value를 기준으로 정렬 위해 List에 저장
		List<Integer> keySet = new ArrayList<>(map.keySet());
		//내침차순
		keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));
        System.out.println("==내림차순 정렬==");
        for (Integer key : keySet) {
            System.out.println(String.format("내림차순 Key : %s, Value : %s", key, map.get(key)));
        }
		// 오름차순
        System.out.println("==오름차순 정렬==");
        keySet.sort((o1, o2) -> map.get(o1) - map.get(o2));
        for (Integer key : keySet) {
            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }
		//---------------------------------------------------
		// 우선순위 Queuec
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		priorityQueue.add(33);
		priorityQueue.add(77);
		priorityQueue.add(11);
		Iterator<Integer> it1 = priorityQueue.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
//		 
		 Stack<Integer> s = new Stack<>(); 
		 s.add(1);
		 s.add(2);
		 s.add(3);
		 System.out.println(s.peek());
		 System.out.println(s.peek());
		 System.out.println(s.pop());
		 System.out.println(s.peek());
		 

		 //---------------------------------------------------
		 // 배열에서 원하는 문자열 index번호 찾기
		 String[] strTest = {"bae","seong","bin"};
		 int strIdx = Arrays.binarySearch(strTest, "seong");
		 System.out.println("찾는 문자열의 인덱스 번호 = "+strIdx);
	}

}
