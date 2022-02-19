package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Hamburger {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N, L, max;
    static int[] taste, cal;
     
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
             
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
             
            combination(0,0,0);
             
            bw.write(String.format("#%d ", tc));
            bw.write(max + "\n");
        }
        bw.flush();
        bw.close();
    }
     
    public static void combination(int cur_L, int cur_T, int start) {
        if(cur_L > L) return;
        if(cur_T>max) max=cur_T;
        
        for(int i=start; i<N; i++) {
        	combination(cur_L + cal[i], cur_T + taste[i], i+1);
        }
    }
     
}
