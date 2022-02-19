package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] towers, res;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		towers = new int[N+1];
		res = new int[N+1];
		stack = new Stack<>();
		
		for(int i=1; i<N+1; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		stack.push(N);
		for(int i=N-1; i>0; i--) {
			while(!stack.isEmpty() && towers[stack.peek()]<towers[i]) {
				res[stack.pop()] = i;
			}
			
			stack.push(i);
		}
		
		for(int i=1; i<=N; i++) {
			bw.write(res[i]+ " ");
		}
		
		bw.flush();
		bw.close();
	}
}
