package day9_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static char[][] map;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		System.out.print(countArea(map)+" ");
		
		changeRG(map); // R을 G로 바꾼다.
		System.out.println(countArea(map));
	}
	
	public static int countArea(char[][] map) {
		// 영역 개수 구하기
		char[][] clone = new char[N][N];
		int areaCnt = 0;
		for(int i=0; i<N; i++) {
			clone[i] = map[i].clone();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(clone[i][j]=='R' || clone[i][j]=='G' || clone[i][j]=='B') {
					getArea(clone, i, j);
					areaCnt++;
				}
			}
		}
		
		return areaCnt;
	}
	
	public static void getArea(char[][] map, int i, int j) {
		// 영역 구하기
		// 같은 영역을 X로 바꿈
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		
		xq.offer(i);
		yq.offer(j);
		char color = map[i][j];
		
		while(!xq.isEmpty()) {
			int x = xq.poll();
			int y = yq.poll();
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N) {
					if(map[nx][ny]==color) {
						xq.offer(nx);
						yq.offer(ny);
						map[nx][ny] = 'X';
					}
				}
			}
		}
	}
	
	public static void changeRG(char[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='R') map[i][j]='G';
			}
		}
	}
}
