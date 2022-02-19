package im대비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_14696 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int tc=0; tc<N; tc++) {
			int[] a = new int[5];
			int[] b = new int[5];
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int i=0; i<count; i++) {
				a[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			count = Integer.parseInt(st.nextToken());
			for(int i=0; i<count; i++) {
				b[Integer.parseInt(st.nextToken())]++;
			}
			
			getWinner(a, b, 4);
		}
		bw.flush();
		bw.close();
	}
	
	public static void getWinner(int[] a, int[] b, int idx) throws IOException{
		if(idx==0) {
			bw.write("D\n");
			return;
		}
		
		if(a[idx]>b[idx]) bw.write("A\n");
		else if(a[idx]<b[idx]) bw.write("B\n");
		else getWinner(a, b, idx-1);
	}
}
