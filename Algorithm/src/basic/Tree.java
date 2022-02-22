package basic;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public Tree(int size) {
		nodes = new char[size+1];
		SIZE = size;
	}
	
	public boolean isEmpty() {
		return lastIndex==0;
	}
	
	public boolean isFull() {
		return lastIndex==SIZE;
	}
	
	public void add(char e) {
		if(isFull()) return;
		
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		if(isEmpty()) return;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(nodes[current]+" ");
			
			if(current*2<=lastIndex) queue.offer(current*2);
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
		}
	}
	
	public void bfs2() {
		if(isEmpty()) return;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);
		int level = 0;
		while(!queue.isEmpty()) {
			System.out.print("level " + level + " ");
			int size = queue.size();
			while(--size>=0) {
				int current = queue.poll();
				
				System.out.print(nodes[current]+" ");
				
				if(current*2<=lastIndex) queue.offer(current*2);
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			++level;
			System.out.println();
		}
	}
	
	public void dfsPreOrder() {
		System.out.println("dfsPreOrder");
		dfsPreOrder(1);
		System.out.println();
	}
	
	private void dfsPreOrder(int current) {
		if(current>lastIndex) return;
		
		System.out.print(nodes[current]+" ");
		
		dfsPreOrder(current*2);
		dfsPreOrder(current*2+1);
	}
	
	public void dfsInOrder() {
		System.out.println("dfsInOrder");
		dfsInOrder(1);
		System.out.println();
	}
	
	private void dfsInOrder(int current) {
		if(current>lastIndex) return;
		
		dfsInOrder(current*2);
		System.out.print(nodes[current]+" ");
		dfsInOrder(current*2+1);
	}
	
	public void dfsPostOrder() {
		System.out.println("dfsPostOrder");
		dfsPostOrder(1);
		System.out.println();
	}
	
	private void dfsPostOrder(int current) {
		if(current>lastIndex) return;
		
		dfsPostOrder(current*2);
		dfsPostOrder(current*2+1);
		System.out.print(nodes[current]+" ");
	}
}
