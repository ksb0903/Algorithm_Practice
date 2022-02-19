package day6_Greedy_Divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Refrigerator {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static LinkedList<int[]> chemical = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] tmps = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			chemical.add(tmps);
		}
		
		Collections.sort(chemical, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(chemical.get(i)));
		}
		
		int count=1;
		int low = chemical.get(0)[0];
		int high = chemical.get(0)[1];
		
		for(int i=1; i<N; i++) {
			if(chemical.get(i)[0]>high || chemical.get(i)[1]<low) {
				low = chemical.get(i)[0];
				high = chemical.get(i)[1];
				count++;
			}
		}
		
		System.out.println(count);
	}
}
