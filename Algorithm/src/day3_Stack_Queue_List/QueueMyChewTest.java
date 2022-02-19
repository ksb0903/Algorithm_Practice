package day3_Stack_Queue_List;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMyChewTest {
	
	public static void main(String[] args) {
		int N=20;
		int person=1;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {person, 1});
		
		while(N>0) {
			int[] p = queue.poll();
			int availableCount = (N>=p[1])?p[1]:N;
			N -= availableCount;
			
			if(N==0) {
				System.out.println("마지막 마이쮸를 가져간 사람: " + p[0]+" , 가져간 개수: "+availableCount);
			}else {
				System.out.println("마이쮸를 가져간 사람: " + p[0]+" , 가져간 개수: "+availableCount);
				
				p[1]++;
				queue.offer(p);
				
				queue.offer(new int[] {++person, 1});
			}
		}
	}
}
