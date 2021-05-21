package algorithm01.description;

// 프로그래머스 문제풀이 스티커 모으기
//N개의 스티커가 원형으로 연결되어 있습니다.
//원형으로 연결된 스티커에서 몇 장의 스티커를 뜯어내어 뜯어낸 스티커에 적힌 숫자의 합이 최대가 되도록 하고 싶습니다.
//단 스티커 한 장을 뜯어내면 양쪽으로 인접해있는 스티커는 찢어져서 사용할 수 없게 됩니다.
//스티커에 적힌 숫자가 배열 형태로 주어질 때, 스티커를 뜯어내어 얻을 수 있는 숫자의 합의 최댓값을 return 하는 solution 함수를 완성해 주세요. 
//원형의 스티커 모양을 위해 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어 있다고 간주합니다.
//제한 사항
	//sticker는 원형으로 연결된 스티커의 각 칸에 적힌 숫자가 순서대로 들어있는 배열로, 길이(N)는 1 이상 100,000 이하입니다.
	//sticker의 각 원소는 스티커의 각 칸에 적힌 숫자이며, 각 칸에 적힌 숫자는 1 이상 100 이하의 자연수입니다.
	//원형의 스티커 모양을 위해 sticker 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어있다고 간주합니다.
public class StickerGather {

	public static void main(String[] args) {
		int solution = solution(new int[] {14, 6, 5, 11, 3, 9, 2, 10});
//		int solution = solution(new int[] {1, 3, 2, 5, 4});
		System.out.println("solution = "+solution);
	}
	public static int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        if(len == 1) {
        	return answer = sticker[0];
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        
        //첫번째 스티커 땔 경우
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i=2; i<len-1; i++) {
        	dp1[i] = Math.max(dp1[i-1],dp1[i-2] + sticker[i]);
        }
        //첫번때 스티커 때지 않을 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i=2; i<len; i++) {
        	dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);
        }
        return answer = Math.max(dp1[len-2],dp2[len-1]);
    }

}
