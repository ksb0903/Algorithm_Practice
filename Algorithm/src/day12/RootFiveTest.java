package day12;

public class RootFiveTest {
	public static void main(String[] args) {
		double L = 0;
		double R = 3;
		double M = 0.0;
		while(Math.abs(L-R)>0.00000000001) {
			M = (L+R)/2;
			if(f(M)*f(R)<0) {
				L = M;
			}else if(f(L)*f(M)<0) {
				R = M;
			}
		}
		System.out.printf("%.9f\n", M);
		System.out.println(Math.sqrt(5));
	}
	
	public static double f(double x) {
		return x*x - 5.0;
	}
}
