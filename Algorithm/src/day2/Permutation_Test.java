package day2;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_Test {
	static int N, R;
	static int[] input, number;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		number = new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0);
	}
	
	public static void permutation(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			number[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
