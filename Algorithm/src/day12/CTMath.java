package day12;

public class CTMath {
	public static void main(String[] args) {
		for(int i=100; i<1000; i++) {
			System.out.println(i + ": " +isPrime(i));
		}
	}
	
	public static void print(int n) {
		int i=2;
		while(n/i!=0) {
			if(n%i==0) {
				System.out.print(i + "*");
				n/=i;
			}else i++;
		}
	}
	
	public static boolean isPrime(int n) {
		boolean isP = true;
		for(int i=3; i<=(int)Math.sqrt(n) ; i++) {
			if(n%i==0) {
				isP = false;
				break;
			}
		}
		return isP;
	}
}
