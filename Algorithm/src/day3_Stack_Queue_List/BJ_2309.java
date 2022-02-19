package day3_Stack_Queue_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ_2309 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> dwarf = new ArrayList<>();
	static int sum=-100;
	static boolean stop;
	static int[] fake = new int[2];
	
	public static void main(String[] args) throws IOException{
		for(int i=0; i<9; i++) {
			dwarf.add(Integer.parseInt(br.readLine()));
			sum += dwarf.get(i);
		}
		Collections.sort(dwarf);
		comb(0, 0, 0);
		for(int i: dwarf) {
			bw.write(i+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int start, int v) throws IOException{
		if(cnt==2) {
			if(sum==v) {
				dwarf.remove(fake[1]);
				dwarf.remove(fake[0]);
				stop = true;
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			fake[cnt] = i;
			comb(cnt+1, i+1, v+dwarf.get(i));
			if(stop) break;
		}
	}
}
