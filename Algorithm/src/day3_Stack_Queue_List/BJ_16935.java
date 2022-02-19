package day3_Stack_Queue_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_16935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, R;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			operate(Integer.parseInt(st.nextToken()));
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				bw.write(arr[i][j]+ " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void operate(int cmd) {
		switch(cmd) {
		case 1:
			op1();
			break;
		case 2:
			op2();
			break;
		case 3:
			op3();
			break;
		case 4:
			op4();
			break;
		case 5:
			op5();
			break;
		case 6:
			op6();
			break;
		}
	}
	
	public static void op1() {
		int[][] copy = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = arr[N-i-1][j];
			}
		}
		System.arraycopy(copy, 0, arr, 0, copy.length);
	}
	
	public static void op2() {
		int[][] copy = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = arr[i][M-j-1];
			}
		}
		System.arraycopy(copy, 0, arr, 0, copy.length);
	}
	
	public static void op3() {
		int[][] copy = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[j][N-i-1] = arr[i][j];
			}
		}
		int tmp=N;
		N=M;
		M=tmp;
		arr = new int[N][M];
		System.arraycopy(copy, 0, arr, 0, copy.length);
	}
	
	public static void op4() {
		int[][] copy = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[M-j-1][i] = arr[i][j];
			}
		}
		int tmp=N;
		N=M;
		M=tmp;
		arr = new int[N][M];
		System.arraycopy(copy, 0, arr, 0, copy.length);
	}
	
	public static void op5() {
		int[][] copy = new int[N][M];
		int hN = N/2;
		int hM = M/2;
		for(int i=0; i<4; i++) {
			for(int r=0; r<hN; r++) {
				for(int c=0; c<hM; c++) {
					copy[r][c] = arr[hN+r][c];
					copy[hN+r][c] = arr[hN+r][hM+c];
					copy[hN+r][hM+c] = arr[r][hM+c];
					copy[r][hM+c] = arr[r][c];
				}
			}
		}
		System.arraycopy(copy, 0, arr, 0, copy.length);
	}
	
	public static void op6() {
		int[][] copy = new int[N][M];
		int hN = N/2;
		int hM = M/2;
		for(int i=0; i<4; i++) {
			for(int r=0; r<hN; r++) {
				for(int c=0; c<hM; c++) {
					copy[r][c] = arr[r][hM+c];
					copy[r][hM+c] = arr[hN+r][hM+c];
					copy[hN+r][hM+c] = arr[hN+r][c];
					copy[hN+r][c] = arr[r][c];
				}
			}
		}
		System.arraycopy(copy, 0, arr, 0, copy.length);
	}
}
