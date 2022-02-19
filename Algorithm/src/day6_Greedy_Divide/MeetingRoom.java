package day6_Greedy_Divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoom {
	
	static class Meeting implements Comparable<Meeting>{
		int start, end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			return this.end!=o.end? this.end-o.end: this.start-o.start;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Meeting[] m = new Meeting[count];
		
		for(int i=0; i<count; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		List<Meeting> result = getSchedule(m);
		StringBuilder sb = new StringBuilder();
		
		sb.append(result.size()).append("\n");
		
		for(Meeting mt: result) {
			sb.append(mt.start).append(" ").append(mt.end).append("\n");
		}
		
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static List<Meeting> getSchedule(Meeting[] m){
		ArrayList<Meeting> result = new ArrayList<>();
		Arrays.sort(m);
		result.add(m[0]);
		
		for(int i=1, size = m.length; i<size; i++) {
			if(result.get(result.size()-1).end<=m[i].start) {
				result.add(m[i]);
			}
		}
		return result;
	}
}
