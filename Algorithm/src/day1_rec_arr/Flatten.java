package day1_rec_arr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int D;
	static int[] arr = new int[100];
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1; tc<=10; tc++) {
			D = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int dump=0; dump<D; dump++) {
				process();
			}
			
			Arrays.sort(arr);
			bw.write(String.format("#%d ", tc));
			bw.write(Math.abs(arr[99]-arr[0]) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void process() {
		Arrays.sort(arr);
		arr[99]--;
		arr[0]++;
	}
}
