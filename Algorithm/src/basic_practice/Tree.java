package basic_practice;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	private int SIZE;
	private char[] tree;
	private int lastIdx;
	
	public Tree(int size) {
		this.SIZE = size;
		tree = new char[size+1];
	}
	
	public boolean isFull() {
		return lastIdx==SIZE;
	}
	
	public boolean isEmpty() {
		return lastIdx==0;
	}
	
	public void add(char e) {
		if(isFull()) return;
		tree[++lastIdx] = e;
	}
	
	public void bfs() {
		if(isEmpty()) return;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		int level = 0;
		while(!queue.isEmpty()) {
			System.out.println("Level " + level + ": ");
			int size = queue.size();
			while(--size >= 0) {
				int poll = queue.poll();
				System.out.print(tree[poll]+" ");
				
				if(poll*2<=lastIdx) queue.offer(poll*2);
				if(poll*2+1<=lastIdx) queue.offer(poll*2+1);
			}
			level++;
			System.out.println();
		}
	}
	
	public void preOrder() {
		System.out.println("preOrder");
		preOrder(1);
		System.out.println();
	}
	
	private void preOrder(int n) {
		if(n>lastIdx) return;
		
		System.out.print(tree[n] + " ");
		preOrder(n*2);
		preOrder(n*2+1);
	}
	
	public void inOrder() {
		System.out.println("inOrder");
		inOrder(1);
		System.out.println();
	}
	
	private void inOrder(int n) {
		if(n>lastIdx) return;
		
		inOrder(n*2);
		System.out.print(tree[n] + " ");
		inOrder(n*2+1);
	}

	public void postOrder() {
		System.out.println("postOrder");
		postOrder(1);
		System.out.println();
	}
	
	private void postOrder(int n) {
		if(n>lastIdx) return;
		
		postOrder(n*2);
		postOrder(n*2+1);
		System.out.print(tree[n] + " ");
	}
}
