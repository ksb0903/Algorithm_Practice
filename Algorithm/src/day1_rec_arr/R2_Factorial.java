package day1_rec_arr;

import java.util.Scanner;

public class R2_Factorial {
	public static int factorial(int n) {
		int res=1;
		for(int i=n; i>0; i--) {
			res *= i;
		}
		return res;
	}
	
	static int res = 1;
	public static void factorial2(int n) {
		if(n==0) return;
		res *= n;
		factorial2(n-1);
	}
	
	public static int factorial3(int n) {
		if(n==1) return 1;
		
		return n * factorial3(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(factorial(n));
		factorial2(n);
		System.out.println(res);
		System.out.println(factorial3(n));
		sc.close();
	}
}
