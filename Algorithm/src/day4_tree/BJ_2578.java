package day4_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board = new int[5][5];
	static int[] nums = new int[25];
	static int[] rowCNT = new int[5];
	static int[] colCNT = new int[5];
	static int[] diaCNT = new int[2];
	
	public static void main(String[] args) throws IOException{
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				nums[i*5+j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(process());
	}
	
	/*사회자가 부르는 숫자가 board의 어느 행, 어느 열에 있는지 체크하며
	 *해당 행, 열 , 대각선 배열 index를 증가시켜준다.
	 *이 중 값이 5인 줄이 3개 이상 되면 종료, count를 출력*/
	
	public static int process() {
		int count=0;
		
		for(count=0; count<25; count++) {
			int line_count=0;
			label: for(int r=0; r<5; r++) {
				for(int c=0; c<5; c++) {
					if(nums[count]==board[r][c]) {
						rowCNT[r]++;
						colCNT[c]++;
						if(r==c)diaCNT[0]++;
						if(r+c==4)diaCNT[1]++;
						
						break label;
					}
				}
			}
	
			if(diaCNT[0]==5) line_count++;
			if(diaCNT[1]==5) line_count++;
			for(int i=0; i<5; i++) {
				if(rowCNT[i]==5)
					line_count++;
				if(colCNT[i]==5)
					line_count++;
			}
			
			if(line_count>=3) break;
		}
		
		return count+1;
	}
}
