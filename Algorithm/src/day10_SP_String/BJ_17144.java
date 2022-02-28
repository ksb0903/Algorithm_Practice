package day10_SP_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, T;
	static int[] airCleaner = {-1, -1};
	static int[][] map, deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(airCleaner[0]==-1) {
						airCleaner[0] = i;
					}else {
						airCleaner[1] = i;
					}
				}
			}
		}
		
		for(int t=0; t<T; t++) {
			map = diffusion(map);
			airClean();
		}
		
		System.out.println(getDust());
	}
	
	public static void airClean(){
		for(int i=airCleaner[0]-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		
		for(int i=0; i<C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		
		for(int i=0; i<airCleaner[0]; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		
		for(int i=C-1; i>1; i--) {
			map[airCleaner[0]][i] = map[airCleaner[0]][i-1];
		}
		
		map[airCleaner[0]][1] = 0;
		
		for(int i=airCleaner[1]+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		
		for(int i=0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		
		for(int i=R-1; i>airCleaner[1]; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		
		for(int i=C-1; i>1; i--) {
			map[airCleaner[1]][i] = map[airCleaner[1]][i-1];
		}
		
		map[airCleaner[1]][1] = 0;
	}
	
	public static int[][] diffusion(int[][] map){
		int[][] clone = new int[R][C];
		
		clone[airCleaner[0]][0] = -1;
		clone[airCleaner[1]][0] = -1;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) {
					int dust = map[i][j];
					for(int d=0; d<4; d++) {
						int r = i + deltas[d][0];
						int c = j + deltas[d][1];
						
						if(r>=0 && c>=0 && r<R && c<C && map[r][c]!=-1) {
							clone[r][c] += map[i][j]/5;
							dust -= map[i][j]/5;
						}
					}
					clone[i][j] += dust;
				}
			}
		}
		
		return clone;
	}
	
	public static int getDust() {
		int sum = 0;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) sum += map[i][j];
			}
		}
		
		return sum;
	}
}
