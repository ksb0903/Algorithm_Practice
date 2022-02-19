package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2628 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, count;
	static ArrayList<Integer> cutN, cutM;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cutN = new ArrayList<>();
		cutM = new ArrayList<>();
		count = Integer.parseInt(br.readLine());
		for(int i=0; i<count; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) {
				cutM.add(Integer.parseInt(st.nextToken()));
			}else {
				cutN.add(Integer.parseInt(st.nextToken()));
			}
		}
		cutM.add(0);
		cutN.add(0);
		cutM.add(M);
		cutN.add(N);
		Collections.sort(cutM);
		Collections.sort(cutN);
		
		int maxM = 0;
		int maxN = 0;
		for(int i=1, size=cutM.size(); i<size; i++) {
			maxM = Math.max(cutM.get(i)-cutM.get(i-1), maxM);
		}
		for(int i=1, size=cutN.size(); i<size; i++) {
			maxN = Math.max(cutN.get(i)-cutN.get(i-1), maxN);
		}
		
		System.out.println(maxM*maxN);
	}
}
