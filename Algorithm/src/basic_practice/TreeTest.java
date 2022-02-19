package basic_practice;

import java.util.Scanner;

public class TreeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Tree tree = new Tree(N);
		for(int i=0; i<N; i++) {
			tree.add((char)(i+65));
		}
		//tree.bfs();
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
	}
}
