package day11_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Processor {
	static int N, map[][], coreCnt, maxCnt, minDist;
	static ArrayList<int[]> core;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			bw.write(String.format("#%d ", tc));
			N = Integer.parseInt(br.readLine());
			core = new ArrayList<>();
			coreCnt = 0;
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(i==0 || i==N-1 || j==0 || j==N-1) continue;
						
						core.add(new int[] {i, j});
						coreCnt++;
					}
				}
			}
			maxCnt = 0;
			minDist = Integer.MAX_VALUE;
			dfs(0, 0, map);
			bw.write(minDist + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int getDist(int[][] arr) {
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==-1) sum++;
			}
		}
		
		return sum;
	}
	
	public static void dfs(int depth, int cnt, int[][] arr) {
		if(coreCnt-depth+cnt<maxCnt) return;
		
		if(depth==coreCnt) {
			if(cnt>maxCnt) {
				minDist = Integer.MAX_VALUE;
				maxCnt = cnt;
				minDist = Math.min(minDist, getDist(arr));
			}else if(cnt==maxCnt) {
				minDist = Math.min(minDist, getDist(arr));
			}
			return;
		}
		
		for(int d=0; d<4; d++) {
			int[][] clone = new int[N][N];
			for(int i=0; i<N; i++) {
				clone[i] = arr[i].clone();
			}
			if(check(clone, d, depth)) {
				dfs(depth+1, cnt+1, clone);
			}else {
				dfs(depth+1, cnt, clone);
			}
		}
	}
	
	public static boolean check(int[][] arr, int dir, int depth) {
		int[] point = core.get(depth);
		
		switch(dir) {
		case 0: // 동
			for(int i=point[1]+1; i<N; i++) {
				if(arr[point[0]][i]!=0) return false;
			}
			for(int i=point[1]+1; i<N; i++) {
				arr[point[0]][i] = -1;
			}
			break;
		case 1: // 서
			for(int i=point[1]-1; i>=0; i--) {
				if(arr[point[0]][i]!=0) return false;
			}
			for(int i=point[1]-1; i>=0; i--) {
				arr[point[0]][i] = -1;
			}
			break;
		case 2: // 남
			for(int i=point[0]+1; i<N; i++) {
				if(arr[i][point[1]]!=0) return false;
			}
			for(int i=point[0]+1; i<N; i++) {
				arr[i][point[1]] = -1;
			}
			break;
		case 3: // 북
			for(int i=point[0]-1; i>=0; i--) {
				if(arr[i][point[1]]!=0) return false;
			}
			for(int i=point[0]-1; i>=0; i--) {
				arr[i][point[1]] = -1;
			}
			break;
		}
		
		return true;
	}
}
