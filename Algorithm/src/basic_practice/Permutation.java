package basic_practice;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	static boolean[] isSelected;
	static int[] numbers;
	static int N, R;
	
	public static void perm_du(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			
			return;
		}
		
		for(int i=1; i<=N; i++) {
			numbers[cnt] = i;
			perm_du(cnt+1);
		}
	}
	
	public static void perm(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			numbers[cnt] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		isSelected = new boolean[N+1];
		numbers = new int[R];
		//perm(0);
		perm_du(0);
	}
}
