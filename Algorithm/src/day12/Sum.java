package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static HashMap<Long, Long> map = new HashMap<>();
	static long A, B;
	
	public static void main(String[] args) throws IOException{
		long mapSum = 0;
		map.put(-1L, 0L);
		for(long i=0; i<=9; i++) {
			mapSum += i;
			map.put(i, mapSum);
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			bw.write(F(B)-F(A-1) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static long F(long x) {
		if(map.containsKey(x)) return map.get(x);
		if(x<10) {
			return map.get(x);
		}
		
		long v = V(x);
		long f = F(x-1-x%v);
		long g = x/v*(x%v+1)+F(x%v);
		long res = f+g;
		
		map.put(x, res);
		
		return res;
	}
	
	public static long V(long x) {
		long v = 1;
		while(x>=10) {
			v = v*10;
			x = x/10;
		}
		return v;
	}
}
