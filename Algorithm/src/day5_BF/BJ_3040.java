package day5_BF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_3040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dwarfs, selected;
	static int sum;
	static boolean stop;
	
	public static void main(String[] args) throws IOException{
		dwarfs = new int[9];
		sum=0;
		for(int i=0; i<9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			sum += dwarfs[i];
		}
		selected = new int[2];
		comb(0, 0);
		for(int i=0; i<9; i++) {
			if(dwarfs[i]!=-1) {
				bw.write(dwarfs[i]+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==2) {
			int fake = 0;
			fake += dwarfs[selected[0]];
			fake += dwarfs[selected[1]];
			
			if(sum-fake==100) {
				dwarfs[selected[0]] = -1;
				dwarfs[selected[1]] = -1;
				stop = true;
			}
			
			return;
		}
		
		for(int i=start; i<9; i++) {
			selected[cnt] = i;
			comb(cnt+1, i+1);
			if(stop) break;
		}
	}
}
