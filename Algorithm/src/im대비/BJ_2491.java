package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr, tmp;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Math.max(bigger(), smaller()));
	}
	
	public static int bigger() {
		int max=0;
		tmp[0] = 1;
		
		for(int i=1; i<N; i++) {
			if(arr[i]>=arr[i-1]) {
				tmp[i] = tmp[i-1]+1;
			}else {
				tmp[i] = 1;
			}
		}
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, tmp[i]);
		}
		
		return max;
	}
	
	public static int smaller() {
		int max=0;
		tmp[0] = 1;
		
		for(int i=1; i<N; i++) {
			if(arr[i]<=arr[i-1]) {
				tmp[i]=tmp[i-1]+1;
			}else {
				tmp[i] = 1;
			}
		}
		for(int i=0; i<N; i++) {
			max = Math.max(max, tmp[i]);
		}
		
		return max;
	}
}

