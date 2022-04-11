package day11_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Arrest {
	static int N, M, R, C, L, map[][];
	static int deltas[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bw.write(String.format("#%d ", tc));
			bw.write(solve() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		if(L==1) {
			return 1;
		}
		int time = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {R, C});
		boolean visited[][] = new boolean[N][M];
		visited[R][C] = true;
		
		while(!q.isEmpty() && time<L) {
			int size = q.size();
			
			while(size>0) {
				int[] point = q.poll();
				int x = point[0];
				int y = point[1];
				int v = map[x][y];
				
				move(x, y, v, q, visited);
				
				--size;
			}
			++time;
		}
		
		return getRes(visited);
	}
	
	public static void move(int x, int y, int cmd, Queue<int[]> q, boolean[][] visited) {
		switch(cmd) {
		case 1:
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny]!=0) {
					if(check(d, map[nx][ny])) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			break;
		case 2:
			for(int d=0; d<4; d++) {
				if(d==0 || d==1) continue;
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny]!=0) {
					if(check(d, map[nx][ny])) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			break;	
		case 3:
			for(int d=0; d<4; d++) {
				if(d==2 || d==3) continue;
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny]!=0) {
					if(check(d, map[nx][ny])) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			break;
		case 4:
			for(int d=0; d<4; d++) {
				if(d==1 || d==2) continue;
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny]!=0) {
					if(check(d, map[nx][ny])) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			break;
		case 5:
			for(int d=0; d<4; d++) {
				if(d==1 || d==3) continue;
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny]!=0) {
					if(check(d, map[nx][ny])) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			break;
		case 6:
			for(int d=0; d<4; d++) {
				if(d==0 || d==3) continue;
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny]!=0) {
					if(check(d, map[nx][ny])) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			break;
		case 7:
			for(int d=0; d<4; d++) {
				if(d==0 || d==2) continue;
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny]!=0) {
					if(check(d, map[nx][ny])) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			break;
		default:
			return;
		}
	}
	
	public static boolean check(int front, int to) {
		switch(front) {
		case 0: // 동
			if(to==1 || to==3 || to==6 || to==7) return true;
			else return false;
		case 1: // 서
			if(to==1 || to==3 || to==4 || to==5) return true;
			else return false;
		case 2: // 남
			if(to==1 || to==2 || to==4 || to==7) return true;
			else return false;
		case 3: // 북
			if(to==1 || to==2 || to==5 || to==6) return true;
			else return false;
		}
		
		return false;
	}

	public static int getRes(boolean[][] v) {
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(v[i][j]) cnt++;
			}
		}
		
		return cnt;
	}
}
