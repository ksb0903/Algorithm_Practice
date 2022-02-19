package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] confetti; // 색종이
	static int[][] paper; // 도화지
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		confetti = new int[N][2];
		int right=0;
		int top=0;
		int sum=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			confetti[i][0] = Integer.parseInt(st.nextToken());
			confetti[i][1] = Integer.parseInt(st.nextToken());
			right = Math.max(right, confetti[i][0]);
			top = Math.max(top, confetti[i][1]);
		}
		paper = new int[right+11][top+11];
		
		paint();
		for(int i=1; i<paper.length; i++) {
			for(int j=1; j<paper[0].length; j++) {
				sum+=paper[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	public static void paint() {
		for(int i=0; i<N; i++) {
			for(int x=confetti[i][0]; x<confetti[i][0]+10; x++) {
				for(int y=confetti[i][1]; y<confetti[i][1]+10; y++) {
					paper[x][y]=1;
				}
			}
		}
	}
}
