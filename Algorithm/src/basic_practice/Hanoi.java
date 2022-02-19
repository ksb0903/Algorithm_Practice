package basic_practice;

import java.util.Scanner;

public class Hanoi {
	
	public static void printHanoi(int n, int start, int mid, int end) {
		if(n==0) return;
		
		printHanoi(n-1, start, end, mid);
		System.out.println(n + ": " + start + " " + end);
		printHanoi(n-1, mid, start, end);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		printHanoi(N, 1, 2, 3);
		
	}
}
