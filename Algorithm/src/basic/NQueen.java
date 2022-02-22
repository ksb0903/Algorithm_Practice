package basic;

import java.util.Scanner;

public class NQueen {
	static int N, ans, col[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		ans = 0;
		setQueen(1);
		System.out.println(ans);
		
	}
	
	public static void setQueen(int rowNo) {
		
		if(!isAvailable(rowNo-1)) return;
		
		if(rowNo>N) {
			ans++;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	public static boolean isAvailable(int rowNo) {
		for(int i=1; i<rowNo; i++) {
			if(col[rowNo]==col[i] || Math.abs(col[rowNo]-col[i])==rowNo-i) return false;
		}
		return true;
	}
}
