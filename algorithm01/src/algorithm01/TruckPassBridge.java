package algorithm01;

import java.util.LinkedList;
import java.util.Queue;

//프로그래머스 다리를 지나는 트럭
//트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
//모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
//트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
//※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
public class TruckPassBridge {

	public static void main(String[] args) {
//		int time = solution(2, 10, new int[] {7,4,5,6});
		int time = solution(100, 100, new int[] {10});
//		int time = solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10});
		System.out.println("모든 트럭이 건너는데 걸린 시간 = "+time);

	}
	//다리 길이 bridge_length
	//다리가 견딜 수 있는 무게 weight
	//트럭별 무게 truck_weights
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int tot = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int truck : truck_weights) {
        	while(true) {
        		if(q.isEmpty()) {
        			answer++;
        			q.offer(truck);
        			tot += truck;
        			break;
        		}else if(q.size() == bridge_length) {
        			tot -= q.poll();
        		}else {
        			if(tot + truck > weight) {
        				answer++;
        				q.offer(0);
        			}else {
        				answer++;
        				q.offer(truck);
        				tot += truck;
        				break;
        			}
        		}
        		
        	}
        }
        
        return answer+bridge_length;
    }

}
