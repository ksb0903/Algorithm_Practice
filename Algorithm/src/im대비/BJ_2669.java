package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2669 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] rec = new int[4][4];
	static int[][] map;
	static int maxX, maxY;
	
	public static void main(String[] args) throws IOException{
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				rec[i][j] = Integer.parseInt(st.nextToken());
				if(j==2) {
					maxX = Math.max(rec[i][j], maxX);
				}
				if(j==3) {
					maxY = Math.max(rec[i][j], maxY);
				}
			}
		}
		map = new int[maxX][maxY];
		solve();
	}
	
	public static void solve() {
		int sum=0;
		for(int i=0; i<4; i++) {
			for(int r=rec[i][0]; r<rec[i][2]; r++) {
				for(int c=rec[i][1]; c<rec[i][3]; c++) {
					map[r][c]=1;
				}
			}
		}
		
		for(int[] ii:map) {
			for(int i:ii) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
}

