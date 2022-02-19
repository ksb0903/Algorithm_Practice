package day4_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SquareRoom {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, N;
	static int[] sum, max;
	static int[][] nums;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			N = Integer.parseInt(br.readLine());
			nums = new int[N*N+1][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());
					nums[num] = new int[] {i, j};
				}
			}
			max = new int[] {0,0};
			sum = new int[] {1,1};
			/*배열 안에 숫자는 1부터 N^2까지 있다. 이 숫자의 좌표를 N^2 배열에 저장하고 비교한다.*/ 
			
			for(int i=2; i<N*N+1; i++) {
				int x1 = nums[i][0];
				int x2 = nums[i-1][0];
				int y1 = nums[i][1];
				int y2 = nums[i-1][1];
				
				if((Math.abs(x1-x2)==1)&&(y1==y2) || (Math.abs(y1-y2)==1)&&(x1==x2)) {
					sum[1]++;
					if(max[1]<sum[1]) max = sum.clone();
				}else {
					sum[0]=i;
					sum[1]=1;
				}
			}
			bw.write(max[0] + " " + max[1] + "\n");
		}
		bw.flush();
		bw.close();
	}
	

}
