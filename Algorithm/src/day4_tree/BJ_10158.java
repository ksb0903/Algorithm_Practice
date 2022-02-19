package day4_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_10158 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int w, h, p, q, t;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());
				
		int x = Math.abs(t-(w-p));
		int y = Math.abs(t-(h-q));
		if((x/w%2)==0){
			System.out.print(w-(x%w));
		}else {
			System.out.print(x%w);
		}
		
		System.out.print(" ");
		
		if((y/h%2)==0){
			System.out.print(h-(y%h));
		}else {
			System.out.print(y%h);
		}
	}
}
