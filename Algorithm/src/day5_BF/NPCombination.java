package day5_BF;

import java.util.Arrays;
import java.util.Scanner;

public class NPCombination {
static int N, R, input[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		int[] p = new int[N];
		int cnt = 0;
		while(++cnt<=R) p[N-cnt]=1;
		
		do {
			for(int i=0; i<N; i++) {
				if(p[i]==1) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
		}while(np(p));
		
		
	}
	
	private static boolean np(int[] p) {
		
		int i = N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		if(i==0) return false;
		
		int j = N-1;
		while(p[i-1]>=p[j]) --j;
		
		swap(p, i-1, j);
		int k = N-1;
		while(i<k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	public static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
}
