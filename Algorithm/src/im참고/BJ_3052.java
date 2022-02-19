package im참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_3052 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		for(int i=0; i<10; i++) {
			set.add(Integer.parseInt(br.readLine())%42);
		}
		System.out.println(set.size());
	}
}
