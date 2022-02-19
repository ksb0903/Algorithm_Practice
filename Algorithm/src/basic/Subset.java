package basic;

import java.util.Scanner;

public class Subset {
	static int N, input[];
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubSet(0);
	}
	
	public static void generateSubSet(int cnt) {
		if(cnt==N) {
			for(int i=0; i<N; i++) {
				System.out.print((isSelected[i]?input[i]:"X")+ " ");
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		isSelected[cnt] = false;
		generateSubSet(cnt+1);
	}
}
