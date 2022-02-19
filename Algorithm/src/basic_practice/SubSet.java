package basic_practice;

import java.util.Arrays;
import java.util.Scanner;

public class SubSet {
	static int N;
	static boolean[] isSelected;
	static int[] numbers;
	
	public static void subset(int cnt) {
		if(cnt==N) {
			for(int i=0; i<N; i++)
				System.out.print((isSelected[i]?numbers[i]:"X")+" ");
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		isSelected = new boolean[N];
		numbers = new int[N];
		for(int i=0; i<N; i++) {
			numbers[i] = i+1;
		}
		
		subset(0);
	}
}
