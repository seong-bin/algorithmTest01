package algorithm01.description;

// 프로그래머스 문제 해설 나머지 한 점
//직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 
//점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요.
//단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
//
//제한사항
	//v는 세 점의 좌표가 들어있는 2차원 배열입니다.
	//v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
	//좌표값은 1 이상 10억 이하의 자연수입니다.
	//직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
public class RemainderDot {

	public static void main(String[] args) {
		int[] solution = solution(new int[][] {{1,4}, {3,4}, {3,10}});
//		System.out.println("solution = "+solution);
	}
	public static int[] solution(int[][] v) {
		int[] answer = new int[2];
		int[] a = new int[2];
//        answer[0]=v[0][0]^v[1][0]^v[2][0];	//4(0100) ^ 4(0100) = 0(0000) ^ 10(1011) = 10(1011)
		//XOR연산 같으면 0임 (두 값의 2진수 각 자릿수 비교하여 같으면 0, 다르면 1 계산)
		answer[0]=v[0][0]^v[1][0];	//4(0100) ^ 4(0100) = 0
        answer[1]=v[0][1]^v[1][1]^v[2][1];
        System.out.println("answer[0] = "+answer[0]);
        System.out.println("answer[1] = "+answer[1]);
        for(int i=0; i<v.length; i++) {
        	a[0] ^= v[i][0];
        	a[1] ^= v[i][1];
        }
        System.out.println("a[0] = "+a[0]);
        System.out.println("a[1] = "+a[1]);
        return answer;
    }

}
