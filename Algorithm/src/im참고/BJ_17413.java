package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17413 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "<> ", true);
		StringBuilder s = new StringBuilder();
		boolean flag = true;
		while(st.hasMoreTokens()) {
			String nextS = st.nextToken();
			if(nextS.equals("<")) {
				flag = false;
			}
			if(nextS.equals(">")) {
				flag = true;
			}
			
			if(flag) {
				StringBuilder sb = new StringBuilder(nextS);
				s.append(sb.reverse());
			}else {
				s.append(nextS);
			}
		}
		
		System.out.println(s);
	}
}

