package day7_BackT_Graph;

import java.util.Scanner;

public class SpaceDivide {
	static int white, green;
	static int[][] spaces;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		spaces = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}
		cut(0, 0, N);
		System.out.println(white);
		System.out.println(green);
	}
	
	public static void cut(int r, int c, int size) {
		int sum = 0;
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				sum+=spaces[i][j];
			}
		}
		
		if(sum==size*size) {
			green++;
		}else if(sum==0) {
			white++;
		}else {
			int half = size/2;
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
		}
	}
}
