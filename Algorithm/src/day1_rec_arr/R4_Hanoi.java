package day1_rec_arr;

public class R4_Hanoi {
	public static void hanoi(int n, int from, int tmp, int to) {
		if(n==0) {
			return;
		}else {
			hanoi(n-1, from, to, tmp);
			System.out.println(n + ": " + from + " " + to);
			hanoi(n-1, tmp, from, to);
		}
	}
	
	public static void main(String[] args) {
		hanoi(3, 1, 2, 3);
	}
}
