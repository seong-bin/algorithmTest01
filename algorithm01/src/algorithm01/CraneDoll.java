package algorithm01;

import java.util.Stack;

public class CraneDoll {

	public static void main(String[] args) {
		int solution = solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}
		, new int[] {1,5,3,5,1,2,1,4});
		System.out.println("사라진 인형의 개수 = "+solution);

	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        //stack 후입선출 자료구조
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int move : moves) {
            for(int i=0; i<board.length; i++) {
                if(board[i][move-1] != 0) {
                    if(stack.peek() == board[i][move-1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][move-1]);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}
