package algorithm01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 모의고사
//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//제한 조건
	//시험은 최대 10,000 문제로 구성되어있습니다.
	//문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
	//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
public class MockTest {

	public static void main(String[] args) {
//		int[] solution = solution(new int[] {1,2,3,4,5});
//		int[] solution = solution(new int[] {1,3,2,4,2});
		int[] solution = solution(new int[] {5});
		Arrays.stream(solution).forEach(x -> System.out.println("가장 많은 문제를 맞힌 사람 = "+x));

	}
	public static int[] solution(int[] answers) {
        int[] supoja = new int[3];
        supoja[0] = getAnswersCnt("supoja1", answers);
        System.out.println(supoja[0]);
        supoja[1] = getAnswersCnt("supoja2", answers);
        System.out.println(supoja[1]);
        supoja[2] = getAnswersCnt("supoja3", answers);
        System.out.println(supoja[2]);
        
        int maxPoint =  Arrays.stream(supoja).max().getAsInt();
        int supojaCnt = (int) Arrays.stream(supoja).filter(x -> x == maxPoint).count();
        int[] answer = new int[supojaCnt];
        int cnt = 0;
        for(int i=0; i<supoja.length; i++) {
        	if(supoja[i] == maxPoint) {
        		answer[cnt] = i+1;
        		cnt++;
        	}
        }
        
        return answer;
	}
	public static int getAnswersCnt(String nickname, int[] answers) {
		int[] supoja = {};
        Queue<Integer> q = new LinkedList<Integer>();
        int point = 0;
        if(nickname.equals("supoja1")) {
            supoja = new int[] {1, 2, 3, 4, 5};
        }else if(nickname.equals("supoja2")) {
            supoja = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        }else {
            supoja = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        }
        Arrays.stream(supoja).forEach(x -> q.add(x));
        for(int an : answers) {
//        	System.out.println(q.peek());
        	if(an == q.peek()) {
        		point++;
        	}
        	q.add(q.poll());
        }
        
		return point;
	}
	
}
