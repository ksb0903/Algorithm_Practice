package day5_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20304 {
	/*안전도가 1인 수부터 차례대로 BFS를 수행한다.
	 * 초기 큐에는  안전도가 0인 P1~Pm이 들어가 있고
	 * 비트마스킹을 이용해 비트 차이가 1인 수를 구한다.
	 * 이때 구하는 방법은 a^b=c, a^c=b임을 이용
	 * 1부터 1<<i까지 xor연산을 하며 c를 구한다.
	 * c는 모두 비트 차이가 1이기때문에
	 * 기존 안전도+1*/
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer;
			
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int arr[] = new int[N+1];
		Arrays.fill(arr, Integer.MIN_VALUE);
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[x] = 0;
			queue.offer(x);
		}
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int i=0; i<20; i++) {
				int nx = x^(1<<i);
				if(nx>N||arr[nx]!=Integer.MIN_VALUE) continue;
				arr[nx] = arr[x]+1;
				queue.offer(nx);
				answer = Math.max(answer, arr[nx]);
			}
		}
		
		System.out.println(answer);
	}
}
