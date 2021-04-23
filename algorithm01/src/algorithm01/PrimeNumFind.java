package algorithm01;

import java.util.HashSet;

//프로그래머스 소수찾기 (완전탐색)
//한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//제한사항
	//numbers는 길이 1 이상 7 이하인 문자열입니다.
	//numbers는 0~9까지 숫자만으로 이루어져 있습니다.
	//"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
// 예제
	//[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
	//11과 011은 같은 숫자로 취급합니다.
public class PrimeNumFind {
	private static HashSet<Integer> primeNumber = new HashSet<> ();
	
	public static void main(String[] args) {
//		int solution = solution("17");
		int solution = solution("123");
		System.out.println("만들 수 있는 소수의 개수 = "+solution);
	}
	public static int solution(String numbers) {
        int answer = 0;
        String[] numStrs = numbers.split("");
        System.out.println(numStrs[1]);
        for(int i=0; i<numStrs.length; i++) {
        	boolean[] check = new boolean[numStrs.length];
        	check[i] = true;
        	primeNumCnt(numStrs, numStrs[i], 1, check);
        }
        answer = primeNumber.size();
        for(int h : primeNumber) {
        	System.out.println("h = "+h);
        }
        return answer;
    }
	public static void primeNumCnt(String[] numStrs, String number, int length, boolean[] check) {
		System.out.println("number = "+number);
		if(primeNumCheck(Integer.parseInt(number))) {
			primeNumber.add(Integer.parseInt(number));
		}
		for(int i=0; i<numStrs.length; i++) {
			if(!check[i]) {
				check[i] = true;
				primeNumCnt(numStrs, number+numStrs[i], length+1, check);
				check[i] = false;
			}
		}
	}
	
	public static boolean primeNumCheck(int num) {
		if(num == 0 || num == 1) {
			return false;
		}else {
    		for(int i=2; i<Math.sqrt(num); i++) {
    			if(num%i == 0) {
    				return false;
    			}
    		}
        }
		return true;
	}
}
