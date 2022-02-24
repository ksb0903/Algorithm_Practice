package day9_MST;

import java.util.Arrays;

public class DJSetTest {
	static int[] p, rank;
	static int N;
	
	public static void makeSet() {
		p = new int[N];
		rank = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a==p[a]) return a;
		return p[a] = findSet(p[a]);
	}
	
	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		if(rank[aRoot] < rank[bRoot]) {
			int tmp = aRoot;
			aRoot = bRoot;
			bRoot = tmp;
		}
			
		p[bRoot] = aRoot;
		if(rank[aRoot] == rank[bRoot]) rank[aRoot]++;
		return true;
	}
	
	public static void main(String[] args) {
		N = 5;
		makeSet();
		
		System.out.println(Arrays.toString(p));
		System.out.println(unionSet(0,1));
		System.out.println(Arrays.toString(p));
		System.out.println(unionSet(2,1));
		System.out.println(Arrays.toString(p));
		System.out.println(unionSet(3,2));
		System.out.println(Arrays.toString(p));
		System.out.println(unionSet(4,2));
		System.out.println(Arrays.toString(p));
		
		System.out.println("==================");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(p));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(p));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(p));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(p));
	}
}
