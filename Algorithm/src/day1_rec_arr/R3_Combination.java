package day1_rec_arr;

public class R3_Combination {
	public static int combination(int n, int r) {
		if(n==r || r==0) return 1;
		
		return combination(n-1, r-1) + combination(n-1, r);
	}
	
	public static void main(String[] args) {
		System.out.println(combination(30, 2));
	}
}
