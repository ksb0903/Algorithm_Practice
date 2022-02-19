package day3_Stack_Queue_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Password {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st, st2;
	static int N, C, x, y;
	static LinkedList<Integer> list;
	
	public static void main(String[] args) throws IOException{
		for(int tc=1; tc<=10; tc++) {
			bw.write(String.format("#%d ", tc));
			N = Integer.parseInt(br.readLine());
			list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			C = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I");
			for(int i=0; i<C; i++) {
				st2 = new StringTokenizer(st.nextToken());
				x = Integer.parseInt(st2.nextToken());
				y = Integer.parseInt(st2.nextToken());
				for(int j=0; j<y; j++) {
					list.add(x++, Integer.parseInt(st2.nextToken()));
				}
			}
			
			for(int i=0; i<10; i++) {
				bw.write(list.get(i) + " ");
			}bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
