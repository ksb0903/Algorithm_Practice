package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Hamburger_Subset {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N, L, max;
    static int[] taste, cal;
    static boolean[] isSelected;
     
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            max = 0;
             
            taste = new int[N];
            cal = new int[N];
            isSelected = new boolean[N];
             
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            
            solve(0); 
            bw.write(String.format("#%d ", tc));
            bw.write(max + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    public static void solve(int cnt) {
    	int t_sum=0;
    	int c_sum=0;
    	if(cnt==N) {
    		for(int i=0; i<N; i++) {
    			if(isSelected[i]) {
	    			t_sum += taste[i];
	    			c_sum += cal[i];
    			}
    		}
    		if(c_sum<=L) {
    			if(t_sum>max) max=t_sum;
    		}
    		
    		return;
    	}
    	isSelected[cnt] = true;
    	solve(cnt+1);
    	isSelected[cnt] = false;
    	solve(cnt+1);
    }
    
     
}
