package algorithm01.description;

// 프로그래머스 문제 해설 : 자릿수 더하기
//자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다
public class DigitsAdd {

	public static void main(String[] args) {
		int solution = solution(123);
		System.out.println("solution = "+solution);
	}
	public static int solution(int n) {
        int answer = 0;
//        String[] strNum = String.valueOf(n).split("");
//        for(String num : strNum) {
//        	answer += Integer.parseInt(num);
//        }
        while(n > 0) {
        	answer += n % 10;
        	n /= 10;
        }
        
        return answer;
    }

}
