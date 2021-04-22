package algorithm01.description;

import java.util.Arrays;

// 플로그래머스 문제풀이 땅따먹기
//땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다. 
//1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 
//단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
//제한사항
	//행의 개수 N : 100,000 이하의 자연수
	//열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
	//점수 : 100 이하의 자연수
public class Ttangttameokgi {

	public static void main(String[] args) {
		int solution = solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}});
		System.out.println("solution = "+solution);
	}
	public static int solution(int[][] land) {
        int answer = 0;
        for(int i=1; i<land.length; i++){
        	// 현재 land의 원소와 이전 land원소 중 가장 큰 값을 더해 현재 land배열에 저장
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
//            System.out.println("i = "+i+" land[i][0] = "+land[i][0]);
//            System.out.println("i = "+i+" land[i][1] = "+land[i][1]);
//            System.out.println("i = "+i+" land[i][2] = "+land[i][2]);
//            System.out.println("i = "+i+" land[i][3] = "+land[i][3]);
        }
        // 가장 끝 배열중 가장 큰 값을 리턴
        return answer = Arrays.stream(land[land.length-1]).max().getAsInt();
//      int[] answer = land[land.length-1];
//        for(int an : answer) {
//        	System.out.println(an);
//        }
//        Arrays.sort(answer);

//        return answer[answer.length-1];
    }
}
