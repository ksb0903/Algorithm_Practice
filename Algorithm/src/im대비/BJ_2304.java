package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_2304 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] pillar;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		pillar = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			pillar[i][0] = Integer.parseInt(st.nextToken());
			pillar[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pillar, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[]o2) {
				return o1[0]-o2[0];
			}
		});
		
		int sum = 0;
		int max = 0;
		int maxIdx = 0;
		for(int i=0; i<N; i++) {
			if(pillar[i][1]>=max) {
				max = pillar[i][1];
				maxIdx = i;
			}
		}
		sum += max;
		sum += getLeft(0, maxIdx);
		sum += getRight(maxIdx, N-1);
		System.out.println(sum);
	}
	
	public static int getLeft(int start, int end) {
		if(start==end) return 0;
		
		int max = 0;
		int maxIdx = 0;
		for(int i=start; i<end; i++) {
			if(pillar[i][1]>max) {
				max = pillar[i][1];
				maxIdx = i;
			}
		}
		
		return max*(pillar[end][0]-pillar[maxIdx][0]) + getLeft(0, maxIdx);
	}
	
	public static int getRight(int start, int end) {
		if(start==end) return 0;
		
		int max = 0;
		int maxIdx = 0;
		for(int i=start+1; i<=end; i++) {
			if(pillar[i][1]>max) {
				max = pillar[i][1];
				maxIdx = i;
			}
		}
		
		return max*(pillar[maxIdx][0]-pillar[start][0]) + getRight(maxIdx, N-1);
	}
}
