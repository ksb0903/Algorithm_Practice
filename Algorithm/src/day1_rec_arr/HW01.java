package day1_rec_arr;

import java.util.Scanner;

public class HW01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			char mode='R';
			int num=1;
			int row=0;
			int col=0;
			
			System.out.println("#"+test_case);
			while(num<=N*N) {
				arr[row][col] = num;
				
				switch(mode) {
				case 'R':
					if(col+1>=N || arr[row][col+1]!=0) {
						mode='D';
						row++;
					}
					else col++;
					break;
				case 'D':
					if(row+1>=N || arr[row+1][col]!=0) {
						mode='L';
						col--;
					}
					else row++;
					break;
				case 'L':
					if(col-1<0 || arr[row][col-1]!=0) {
						mode='U';
						row--;
					}
					else col--;
					break;
				case 'U':
					if(row-1<0 || arr[row-1][col]!=0) {
						mode='R';
						col++;
					}
					else row--;
					break;		
				}
				
				num++;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		sc.close();
	}
}
