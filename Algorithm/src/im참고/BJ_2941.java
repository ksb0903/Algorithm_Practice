package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws IOException{
		String s = br.readLine();
		
		for(int i=0; i<cro.length; i++) {
			s = s.replace(cro[i], "*");
		}
		
		System.out.println(s.length());
	}
}
