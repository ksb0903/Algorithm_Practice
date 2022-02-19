package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2851 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int answer = 0;
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum += Integer.parseInt(br.readLine());
			if(Math.abs(100-sum)<=Math.abs(100-answer)) {
				answer = sum;
			}else break;
		}
		System.out.println(answer);
	}
}
