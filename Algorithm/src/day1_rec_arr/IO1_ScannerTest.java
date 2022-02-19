package day1_rec_arr;

import java.util.Scanner;

public class IO1_ScannerTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 기?");
		System.out.println("==>SSAFY " + sc.nextInt() + "기");
		
		System.out.print("한 마디");
		System.out.println("==> " + sc.nextLine());
		
		sc.close();
	}

}
