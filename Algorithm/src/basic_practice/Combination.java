package basic_practice;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
	
	static int N, R;
	static int[] numbers;
	
	public static void comb_du(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<=N; i++) {
			numbers[cnt] = i;
			comb_du(cnt+1, i);
		}
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<=N; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		//comb(0,1);
		comb_du(0,1);
	}
}
