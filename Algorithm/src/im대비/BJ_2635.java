package im대비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2635 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		int max=0;
		int maxNum=0;
		
		for(int i=N/2; i<=N; i++) {
			int returnValue = solve(i);
			if(max<returnValue) {
				max=returnValue;
				maxNum=i;
			}
		}
		
		bw.write(max+"\n");
		bw.write(N+" ");
		bw.write(maxNum+" ");
		for(int i=0; i<max-2; i++) {
			int tmp=maxNum;
			maxNum=N-tmp;
			N=tmp;
			
			bw.write(maxNum+" ");
		}
		bw.flush();
		bw.close();
	}
	
	public static int solve(int num) {
		int count=1;
		int minus=0;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(N);
		queue.offer(num);
		while(minus>=0) {
			minus = queue.poll()-queue.peek();
			queue.offer(minus);
			count++;
		}
		
		return count;
	}
}

