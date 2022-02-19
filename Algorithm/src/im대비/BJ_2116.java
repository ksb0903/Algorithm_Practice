package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2116 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dice;
	static int N, max;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		max = 0;
		dice = new int[N][6];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*맨 아래의 주사위 방향에 따라 결정(6가지 경우의 수)
		나머지 주사위는 바닥이 고정되있으므로 바닥, 바닥 반대 제외 나머지중 최대값 구하기*/
		for(int i=0; i<6; i++) {
			//바닥 정하기
			int sum = 0;
			int bottom = i;
			int ceiling = getCeiling(bottom);
			sum += getMax(0, bottom, ceiling);
			
			for(int j=1; j<N; j++) {
				for(int k=0; k<6; k++) {
					if(dice[j][k]==dice[j-1][ceiling]) {
						bottom = k;
						break;
					}
				}
				ceiling = getCeiling(bottom);
				sum += getMax(j, bottom, ceiling);
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
	
	public static int getMax(int idx, int bottom, int ceiling) {
		if(dice[idx][bottom]==6||dice[idx][ceiling]==6) {
			if(dice[idx][bottom]==5||dice[idx][ceiling]==5) {
				return 4;						
			}else
				return 5;
		}else return 6;
	}
	
	public static int getCeiling(int bottom) {
		//인덱스로 처리
		switch(bottom) {
		case 0:
			return 5;
		case 1:
			return 3;
		case 2:
			return 4;
		case 3:
			return 1;
		case 4:
			return 2;
		case 5:
			return 0;
		}
		
		return -1;
	}
}
