package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Poker {
	static int[][] cards;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			cards = new int[5][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<5; i++) {
				String s = st.nextToken();
				switch(s.charAt(0)) { // 스페이드 클로버 하트 다이아
				case 'S':
					cards[i][0] = 0;
					break;
				case 'C':
					cards[i][0] = 1;
					break;
				case 'H':
					cards[i][0] = 2;
					break;
				case 'D':
					cards[i][0] = 3;
					break;
				}
				
				switch(s.charAt(1)) {
				case 'A':
					cards[i][1] = 1;
					break;
				case 'T':
					cards[i][1] = 10;
					break;
				case 'J':
					cards[i][1] = 11;
					break;
				case 'Q':
					cards[i][1] = 12;
					break;
				case 'K':
					cards[i][1] = 13;
					break;
				default:
					cards[i][1] = (int)s.charAt(1)-'0';
					break;
				}
			}
			bw.write(String.format("#%d ", tc));
			bw.write(getGrade() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static String getGrade() {
		int grade = 9;
		int nums[] = new int[14];
		int shape[] = new int[4];
		int four = 0;
		int three = 0;
		int two = 0;
		
		for(int i=0; i<5; i++) {
			shape[cards[i][0]]++;
			nums[cards[i][1]]++;
		}
		
		for(int i=0; i<4; i++) {
			if(shape[i]==5) {
				if(isStraight(nums)) {
					grade = Math.min(grade, 1);
				}else {
					grade = Math.min(grade, 4);
				}
			}
		}
		
		for(int i=1; i<=13; i++) {
			if(nums[i]==2) two++;
			else if(nums[i]==3) three++;
			else if(nums[i]==4) four++;
		}
		
		if(four==1) {
			grade = Math.min(grade, 2);
		}else if(three==1) {
			if(two==1) grade = Math.min(grade, 3);
			else grade = Math.min(grade, 6);
		}else if(two==2) {
			grade = Math.min(grade, 7);
		}else if(two==1) {
			grade = Math.min(grade, 8);
		}else {
			if(isStraight(nums)) grade = Math.min(grade, 5);
			else grade = Math.min(grade, 9);
		}
		
		switch(grade) {
		case 1:
			return "Straight Flush";
		case 2:
			return "Four of a Kind";
		case 3:
			return "Full House";
		case 4:
			return "Flush";
		case 5:
			return "Straight";
		case 6:
			return "Three of a kind";
		case 7:
			return "Two pair";
		case 8:
			return "One pair";
		default:
			return "High card";
		}
	}
	
	public static boolean isStraight(int[] nums) {
		int zero = 0;
		int one = 0;
		for(int i=1; i<=13; i++) {
			if(zero==8||one==5) return true;
			if(nums[i]==0) {
				zero++;
				one = 0;
			}else {
				zero = 0;
				one++;
			}
		}
		if(zero==8||one==5) return true;
		else return false;
	}
}
