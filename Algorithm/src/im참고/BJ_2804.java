package im참고;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2804 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static String A, B;
	static char[][] puzzle;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();
		puzzle = new char[B.length()][A.length()];
		int row = 0;
		int col = 0;
		
		outer: for(int i=0; i<A.length(); i++) {
			for(int j=0; j<B.length(); j++) {
				if(A.charAt(i)==B.charAt(j)) {
					col = i;
					row = j;
					break outer;
				}
			}
		}
		
		for(int i=0; i<B.length(); i++) {
			for(int j=0; j<A.length(); j++) {
				if(i==row) {
					puzzle[i][j] = A.charAt(j);
				}else if(j==col) {
					puzzle[i][j] = B.charAt(i);
				}else {
					puzzle[i][j] = '.';
				}
				bw.write(puzzle[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
