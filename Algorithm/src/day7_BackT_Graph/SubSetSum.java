package day7_BackT_Graph;


import java.util.Scanner;

public class SubSetSum {
	static int N, S, ans;
	static boolean[] isSelected;
	static int[] numbers;
	
	public static void subset(int cnt) {
		if(cnt==N) {
			int sum=0;
			int eleCnt=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) { 
					sum+= numbers[i];
					eleCnt++;
				}
			}
			
			if(sum==S && eleCnt!=0) {
				++ans;
				for(int i=0; i<N; i++)
					System.out.print((isSelected[i]?numbers[i]+" ":""));
				System.out.println();
			}
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
		S = sc.nextInt();
		isSelected = new boolean[N];
		numbers = new int[N];
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		subset(0);
		System.out.println(ans);
		sc.close();
	}
}
