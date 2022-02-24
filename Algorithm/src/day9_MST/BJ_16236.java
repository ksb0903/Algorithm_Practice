package day9_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, time=0, size=2, eatCnt=0;
	static int[][] map, deltas = {{-1,0}, {0,-1},{0,1},{1,0}};
	static int[] pos;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][j]=0;
					pos = new int[] {i, j};
				}
			}
		}
		
		solve();
		System.out.println(time);
	}
	
	public static void solve() {
		int[] foodPos = new int[3]; // 물고기 행, 열, 거리
		while(true) {
			foodPos = getFood(foodPos);
			if(foodPos[0]==-1) return;
			
			eatFood(foodPos);
		}
	}
	
	public static void eatFood(int[] foodPos) {
		// 시간 계산, 위치 갱신, 크기 갱신
		time += foodPos[2];
		pos[0] = foodPos[0];
		pos[1] = foodPos[1];
		map[foodPos[0]][foodPos[1]] = 0;
		eatCnt++;
		
		if(eatCnt==size) {
			size++;
			eatCnt = 0;
		}
	}
	
	public static int[] getFood(int[] foodPos) {
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		boolean[][] visited = new boolean[N][N]; 
		int dist = 1;
		boolean flag = false;
		int retX=Integer.MAX_VALUE;
		int retY=Integer.MAX_VALUE;
		xq.offer(pos[0]);
		yq.offer(pos[1]);
		visited[pos[0]][pos[1]] = true;
		
		while(!xq.isEmpty()) {
			int qsize = xq.size(); // 거리 계산용
			
			if(flag) return new int[] {retX, retY,dist-1};
			
			for(int q=0; q<qsize; q++) {
				int x = xq.poll();
				int y = yq.poll();
				
				for(int d=0; d<4; d++) {
					int nx = x + deltas[d][0];
					int ny = y + deltas[d][1];
					
					if(nx>=0 && ny>=0 && nx<N && ny<N) {
						if(visited[nx][ny]) continue;
						
						if(map[nx][ny]==0 || map[nx][ny]==size) {
							xq.offer(nx);
							yq.offer(ny);
							visited[nx][ny] = true;
						}else if(map[nx][ny]<size) {
							flag = true;
							if(retX>nx) {
								retX = nx;
								retY = ny;
							}else if(retX==nx) {
								if(retY>ny) {
									retY = ny;
								}
							}
							visited[nx][ny] = true;
						}
					}
				}
			}
			dist++;
		}
		
		if(flag) return new int[] {retX, retY,dist-1};
		else return new int[] {-1, -1};
	}
}
