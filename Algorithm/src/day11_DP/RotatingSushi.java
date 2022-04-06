package day11_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotatingSushi {
	static int N, D, K, C, sushi[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solve());
	}
	
	public static int solve() {
		int nums[] = new int[D+1]; // 초밥 번호 별로 몇개나 먹었는지 기록
		
		int cnt = 0; // 먹은 초밥 종류
		int max = 0; // 최대 종류
		boolean isC = false; // 무료 초밥이 포함되었나?
		
		for(int i=0; i<K; i++) { // 처음 K개만큼 선택(0 ~ K-1번째 접시)
			if(nums[sushi[i]]++==0) {
				cnt++;
			}
			if(sushi[i]==C) isC = true;
		}
		
		max = (isC)? cnt: cnt+1; 
		int end = K;
		
		for(int start=0; start<N; start++) { // 투포인터 방식으로 맨 앞 접시 빼고, 다음 접시 더하고
			if(--nums[sushi[start]]==0) {
				cnt--;
				
				if(sushi[start]==C) isC = false;
			}
			
			if(nums[sushi[end]]++==0) {
				cnt++;
			}
			if(sushi[end]==C) isC = true;
			
			max = Math.max(max, (isC)? cnt: cnt+1);
			end = (end==N-1)? 0: end+1;
		}
		
		return max;
	}
}
