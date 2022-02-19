package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int X, Y, N;
	static int[][] shop;
	static int[] dg;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		shop = new int[N][2];
		dg = new int[2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			shop[i][0] = Integer.parseInt(st.nextToken());
			shop[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		dg[0] = Integer.parseInt(st.nextToken());
		dg[1] = Integer.parseInt(st.nextToken());
		
		System.out.println(solve());
	}
	
	
	public static int solve() {
		int min = 0;
		
		for(int i=0; i<N; i++) {
			if(dg[0]==shop[i][0]) {
				min+=Math.abs(dg[1]-shop[i][1]);
			}
			else if((dg[0]==1 && shop[i][0]==2)||(dg[0]==2 && shop[i][0]==1)) {
				min+=Y;
				min+= Math.min(dg[1]+shop[i][1], 2*X-(dg[1]+shop[i][1]));
			}
			else if((dg[0]==3 && shop[i][0]==4)||(dg[0]==4 && shop[i][0]==3)) {
				min+=X;
				min+= Math.min(dg[1]+shop[i][1], 2*Y-(dg[1]+shop[i][1]));
			}else {
				switch(dg[0]) {
				case 1:
					if(shop[i][0]==3) {
						min+=dg[1];
						min+=shop[i][1];
					}else if(shop[i][0]==4) {
						min+=X-dg[1];
						min+=Y-shop[i][1];
					}
					break;
				case 2:
					if(shop[i][0]==3) {
						min+=dg[1];
						min+=Y-shop[i][1];
					}else if(shop[i][0]==4) {
						min+=X-dg[1];
						min+=Y-shop[i][1];
					}
					break;
				case 3:
					if(shop[i][0]==1) {
						min+=dg[1];
						min+=shop[i][1];
					}else if(shop[i][0]==2) {
						min+=Y-dg[1];
						min+=shop[i][1];
					}
					break;
				case 4:
					if(shop[i][0]==1) {
						min+=dg[1];
						min+=X-shop[i][1];
					}else if(shop[i][0]==2) {
						min+=Y-dg[1];
						min+=X-shop[i][1];
					}
					break;
				}
			}
		}
		
		return min;
	}
}
