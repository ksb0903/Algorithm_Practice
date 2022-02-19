package day5_BF;
import java.util.Arrays;
import java.util.Scanner;

public class Permutation_Bit {
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
		
		permutation(0, 0);
	}
	
	public static void permutation(int cnt, int flag) {
		if(cnt==R) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((flag&1<<i) != 0) continue;
			
			number[cnt] = input[i];
			permutation(cnt+1, flag|1<<i);
		}
	}
}
