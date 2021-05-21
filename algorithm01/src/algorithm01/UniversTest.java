package algorithm01;

public class UniversTest {

	public static void main(String[] args) {
//		String s = "0strong";
		String s = "0agaatgca";
//		String t = "0stone";
		String t = "0acaagtga";
		int[][] e = new int[s.length()][t.length()];
		e[0][0] = 0;
		for(int i=1; i<e.length; i++) {
			e[i][0] = i;
		}
		for(int j=1; j<e[0].length; j++) {
			e[0][j] = j;
		}
		
		for(int i=1; i<e.length; i++) {
			for(int j=1; j<e[i].length; j++) {
				if(String.valueOf(s.charAt(i)).equals(String.valueOf(t.charAt(j)))){
                    e[i][j] = e[i-1][j-1];
                }else{
                    e[i][j] = Math.min(e[i][j-1],Math.min(e[i-1][j],e[i-1][j-1])) + 1;
                }
				System.out.print(e[i][j]+" ");
			}
			System.out.println();
		}
//		for(int i=0; i<e.length; i++) {
//			System.out.print(e[i][0]+" ");
//		}
//		System.out.println();
//		for(int i=0; i<e[i].length; i++) {
//			System.out.print(e[0][i]+" ");
//		}
		System.out.println(e[s.length()-1][t.length()-1]);
	}

}
