package day4_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1158 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int N, K;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] res = new int[N];
		int idx=1;
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		bw.write("<");
		while(idx<=N) {
			
			for(int i=0; i<K-1; i++) {
				queue.offer(queue.poll());
			}
			if(idx==N) {
				bw.write(queue.poll()+"");
			}else bw.write(queue.poll() + ", ");
			idx++;
		}
		
		bw.write(">");
		bw.flush();
		bw.close();
	}
}
