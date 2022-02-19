package day7_BackT_Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DoubleArmScale {
	static int count, N;
	static int[] weight, facts, pows;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write(String.format("#%d ", tc));
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			isSelected = new boolean[N];
			st = new StringTokenizer(br.readLine());
			int weightSum = 0;
			facts = new int[N+1];
			pows = new int[N+1];
			facts[0]=1;
			pows[0]=1;
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				weightSum += weight[i];
				facts[i+1] = facts[i]*(i+1);
				pows[i+1] = pows[i]*2;
			}
			count=0;
			getSequence(0, 0, 0, weightSum);
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void getSequence(int cnt, int left, int right, int remainder) {
		if(left >= right + remainder) {
			count += pows[N-cnt]*facts[N-cnt];
			return;
		}
		
		if(cnt==N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			getSequence(cnt+1, left+weight[i], right, remainder-weight[i]);
			
			if(left>=right+weight[i]) {
				getSequence(cnt+1, left, right+weight[i], remainder-weight[i]);
			}
			
			isSelected[i] = false;
		}
	}
}
