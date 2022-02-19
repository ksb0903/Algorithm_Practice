package day3_Stack_Queue_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_2605 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] num;
	static LinkedList<Integer> line = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			line.add(i-num[i], i+1);
		}
		for(int i=0; i<N; i++) {
			bw.write(line.get(i)+" ");
		}
		bw.flush();
		bw.close();
	}
}
