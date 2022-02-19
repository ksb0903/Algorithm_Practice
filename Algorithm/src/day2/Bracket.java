package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Bracket {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			boolean flag = true;
			Stack<Character> stack = new Stack<>();
			bw.write(String.format("#%d ", tc));
			
			for(int i=0; i<N; i++) {
				if(arr[i]=='[' || arr[i]=='(' || arr[i]=='{' || arr[i]=='<') {
					stack.push(arr[i]);
				}else {
					if(arr[i]==']') {
						if(stack.peek()!='[') {
							flag=false;
							break;
						}
					}
					if(arr[i]==')') {
						if(stack.peek()!='(') {
							flag=false;
							break;
						}
					}
					if(arr[i]=='}') {
						if(stack.peek()!='{') {
							flag=false;
							break;
						}
					}
					if(arr[i]=='>') {
						if(stack.peek()!='<') {
							flag=false;
							break;
						}
					}
					stack.pop();
				}
			}
			if(flag) bw.write(1+"\n");
			else bw.write(0+"\n");
		}
		bw.flush();
		bw.close();
	}
}
