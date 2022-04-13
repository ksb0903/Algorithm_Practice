package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Race {
	static int N, M;
	static long seq[], dp[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			seq = new long[N+1];
			dp = new long[1<<(N+1)];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				seq[b] = seq[b]|(1<<a); // seq[x]는 x보다 빨리 들어온 사람 목록
			}
			
			bw.write(String.format("#%d ", tc));
			bw.write(dfs(0) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static long dfs(int idx) {
		if(idx==(1<<N+1)-2) return 1; // N=3 인 경우 모든 사람이 들어오면 1110 
		if(dp[idx]!=0) return dp[idx];
		
		for(int i=1; i<=N; i++) {
			if(((1<<i)&idx) != 0) continue; // idx에 i가 이미 포함됨
			if((seq[i]&idx) != seq[i]) continue; // i보다 seq[i]의 사람들이 먼저 들어와야함
			dp[idx] += dfs(idx|(1<<i));
		}
		
		return dp[idx];
	}
}
