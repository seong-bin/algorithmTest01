package algorithm01;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
// 프로그래머스 기능개발
//프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
//또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
//먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
//각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
//제한 사항
	//작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
	//작업 진도는 100 미만의 자연수입니다.
	//작업 속도는 100 이하의 자연수입니다.
	//배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
public class FunctionDev {

	public static void main(String[] args) {
//		int[] solution = solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
//		int[] solution = solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1});
		int[] solution = solution(new int[] {20, 99, 93, 30, 55, 10}, new int[] {5, 10, 1, 1, 30, 5});
		Arrays.stream(solution).forEach(x -> System.out.println("한번에 배포되는 기능 = "+x));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		ArrayList<Integer> arr = new ArrayList<> ();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<progresses.length; i++) {
			double dev = ( (double) 100 - progresses[i]) / speeds[i];
			int devDay = (int) Math.ceil(dev);
			System.out.println("dev = "+dev+" devDay = "+devDay);
			arr.add(devDay);
		}
		for(int i=0; i<arr.size(); i++) {
			int count = 1;
			int idx = 0;
			for(int j=i+1; j<arr.size(); j++) {
				System.out.println("arr i = "+arr.get(i)+" arr j = "+arr.get(j));
				if(arr.get(i) >= arr.get(j)) {
					System.out.println("come");
					count++;
					idx++;
				}else {
					break;
				}
			}
			System.out.println("cnt = "+count);
			i += idx;
			q.add(count);
		}
		answer = new int[q.size()];
		int idx = 0;
		while(!q.isEmpty()) {
			answer[idx] = q.poll();
			idx++;
		}
		return answer;
		
	}
}


//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//class Solution {
//    public int[] solution(int[] progresses, int[] speeds) {
//        List<Integer> list = new ArrayList<Integer>();
//        Queue q = new LinkedList();
//
//        int count = progresses.length == speeds.length ? progresses.length : 0;
//        for (int i = 0; i < count; i++) {
//            double day = ((double) 100 - progresses[i]) / speeds[i];
//            list.add((int) Math.ceil(day));
//        }
//        int j = 0;
//        for (int i = 0; i < list.size(); i=j) {
//            int cnt = 1;
//            for ( j = i+1; j < list.size(); j++) {
//                if (list.get(i) >= list.get(j)) {
//                    cnt += 1;
//                } else {
//                    break;
//                }
//            }
//
//            q.offer(cnt);
//        }
//
//        int[] answer = new int[q.size()];
//        int cnt = 0;
//        while (!q.isEmpty()) {
//            answer[cnt++] = (int) q.poll();
//        }
//        return answer;
//    }
//}
