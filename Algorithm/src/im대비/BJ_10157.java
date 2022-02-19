package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10157 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int C, R, K;
	static int[][] seat;
	/*C행 R열 배열로 생각*/
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		seat = new int[C+1][R+1];

		if(K>C*R) System.out.println(0);
		else {
			fillSeat();
			outer:for(int i=1; i<=C; i++) {
				for(int j=1; j<=R; j++) {
					if(seat[i][j]==K) {
						System.out.println(i+" "+j);
						break outer;
					}
				}
			}
		}
	}
	
	public static void fillSeat() {
		int person = 1;
		int startX = 1;
		int startY = 0;
		int rCount = R;
		int cCount = C-1;
		
		while(true) {
			for(int i=0; i<rCount; i++) { //동쪽
				seat[startX][++startY] = person++;
				if(person>K)return;
			}
			
			for(int i=0; i<cCount; i++) { //남쪽
				seat[++startX][startY] = person++;
				if(person>K)return;
			}
			cCount--;
			rCount--;
			
			for(int i=0; i<rCount; i++) { //서쪽
				seat[startX][--startY] = person++;
				if(person>K)return;
			}
			
			for(int i=0; i<cCount; i++) { //북쪽
				seat[--startX][startY] = person++;
				if(person>K)return;
			}
			rCount--;
			cCount--;
		}
	}
}
