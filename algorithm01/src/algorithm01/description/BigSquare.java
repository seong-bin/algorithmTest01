package algorithm01.description;

// 프로그래머스 가장 큰 정사각형 찾기
public class BigSquare {

	public static void main(String[] args) {
//		int solution = solution(new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}});
		int solution = solution(new int[][] {{0,0,1,1},{1,1,1,1}});
		System.out.println("solution = "+solution);
	}
	public static int solution(int [][]board) {
        int answer = 0;
        //board 배열의 x, y축의 길이를 구한다
        int row = board.length;
        int col = board[0].length;
        int max = 0;
        if(row <= 1 || col <= 1) {
        	return answer = 1;
        }
        
        for(int i=1; i<row; i++) {
        	for(int j=1; j<col; j++) {
        		//board의 (1,1)부터 돌면서 board[i][j]가 1이 이상인 경우에
        		if(board[i][j] >= 1) {
        			// 상단, 왼쪽, 왼쪽상단의 값 중 가장 작은값을 구한다
        			System.out.println("i = "+i+" j = "+j+ "111");
        			int min = Math.min(board[i][j-1], Math.min(board[i-1][j], board[i-1][j-1]));
        			System.out.println("i = "+i+" j = "+j+ "222");
        			//최솟값 + 1을 board[i][j]에 넣는다
        			board[i][j] = min+1;
        			System.out.println("i = "+i+" j = "+j+ "333");
        			//max와 최솟값 +1 을 비교해 더 큰 값을 max에 넣는다
        			max = Math.max(max, min+1);
        			System.out.println("i = "+i+" j = "+j+ " 444");
        		}
        	}
        }
        //max 제곱하여 리턴
        return answer = max*max;
    }
}
