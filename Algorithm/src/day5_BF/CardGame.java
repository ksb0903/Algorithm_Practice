package day5_BF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, winCount, loseCount;
	static int[] kyu = new int[9];
	static int[] in = new int[9];
	static int[] res = new int[9];
	static boolean[] nums = new boolean[19];
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			Arrays.fill(nums, false);
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				nums[kyu[i]] = true;
			}
			
			int idx=0;
			for(int i=1; i<=18; i++) {
				if(!nums[i]) {
					in[idx++] = i;
				}
			}
			winCount = 0;
			loseCount = 0;
			isSelected = new boolean[9];
			perm(0);
			bw.write(winCount + " " + loseCount + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void perm(int cnt) {
		if(cnt==9) {
			int sum_kyu = 0;
			int sum_in = 0;
			for(int i=0; i<9; i++) {
				if(kyu[i]>res[i]) {
					sum_kyu += (kyu[i]+res[i]);
				}else {
					sum_in += (kyu[i]+res[i]);
				}
			}
			if(sum_kyu>sum_in) winCount++;
			else if(sum_kyu<sum_in) loseCount++;
			
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			res[cnt] = in[i];
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}
