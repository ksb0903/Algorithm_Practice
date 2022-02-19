package day3_Stack_Queue_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MakePW {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException{
		for(int tc=1; tc<=10; tc++) {
			bw.write(String.format("#%d ", tc));
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			queue = new LinkedList<Integer>();
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			process();
			for(int i=0; i<8; i++) {
				bw.write(queue.poll()+" ");
			}bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void process() {
		while(cycle()) {}
	}
	
	public static boolean cycle() {
		int minus=1;
		while(minus<=5) {
			int poll = queue.poll()-minus++;
			if(poll<=0) {
				queue.offer(0);
				return false;
			}
			queue.offer(poll);
		}
		return true;
	}
}
