package day6_Greedy_Divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, r, c;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int c_value=0;
		int r_value=0;
		
		c_value = getValue(c);
		r_value = getValue(r)*2;
		
		System.out.println(c_value + r_value);
	}
	
	public static int getValue(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		int num=0;
		
		if(n%2==0) {
			num = n;
			return getValue(num>>1)*4;
		}else {
			num = n-1;
			return getValue(num>>1)*4+1;
		}
		
	}
}
