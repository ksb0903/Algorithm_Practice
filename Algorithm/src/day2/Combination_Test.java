package day2;

import java.util.Arrays;
import java.util.Scanner;

public class Combination_Test {
	static int N, R;
	static int[] input, number;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		number = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0, 0);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for(int i=start; i<N; i++) {
			number[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
}
