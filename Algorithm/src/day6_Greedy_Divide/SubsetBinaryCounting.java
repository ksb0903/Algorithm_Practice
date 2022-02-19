package day6_Greedy_Divide;

import java.util.Scanner;

public class SubsetBinaryCounting {
	static int N, input[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		subSet();
		sc.close();
	}
	
	private static void subSet() {
		for(int flag=0, caseCount=1<<N; flag<caseCount; flag++) {
			for(int i=0; i<N; i++) {
				if((flag&1<<i)!=0) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
		}
	}
}
