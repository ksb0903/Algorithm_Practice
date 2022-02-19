package day7_BackT_Graph;

import java.util.Scanner;

public class SubSetSum2 {
	static int N, S, ans;
	static boolean[] isSelected;
	static int[] numbers;

	public static void subset(int cnt, int sum) {
		if(sum == S) {
			++ans;
			for (int i = 0; i < cnt; i++)
				System.out.print((isSelected[i] ? numbers[i] + " " : ""));
			System.out.println();
			return;
		}
		
		if(cnt==N || sum>S) return;
		
		isSelected[cnt] = true;
		subset(cnt + 1, sum + numbers[cnt]);
		isSelected[cnt] = false;
		subset(cnt + 1, sum);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		isSelected = new boolean[N];
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}

		subset(0, 0);
		System.out.println(ans);
		sc.close();
	}
}
