package day8_Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int L, C;
	static char[] password, chars;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		chars = new char[C];
		password = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chars);
		
		comb(0, 0);
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int start) throws IOException{
		if(cnt==L) {
			StringBuilder sb = new StringBuilder();
			String s = "aeiou";
			int vowels = 0;
			int consonants = 0;
			for(int i=0; i<L; i++) {
				if(s.contains(String.valueOf(password[i]))) {
					vowels++;
				}else {
					consonants++;
				}
				sb.append(password[i]);
			}
			
			if(vowels>=1 && consonants>=2) {
				bw.write(sb.toString());
				bw.write("\n");
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			password[cnt] = chars[i];
			comb(cnt+1, i+1);
		}
	}
}
