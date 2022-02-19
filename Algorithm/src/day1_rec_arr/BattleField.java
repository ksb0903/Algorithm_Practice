package day1_rec_arr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BattleField {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int T, H, W, N;
	static char[] cmd;
	static char[][] map;
	
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for(int r=0; r<H; r++) {
				map[r] = br.readLine().toCharArray();
			}
			
			N = Integer.parseInt(br.readLine());
			cmd = br.readLine().toCharArray();
			
			play();	
		}
		bw.write(String.format("#%d ", T));
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void play() {
		int x=0;
		int y=0;
		char direction = 'A';
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]=='<') {
					x=i;
					y=j;
					direction='L';
					break;
				}
				if(map[i][j]=='>') {
					x=i;
					y=j;
					direction='R';
					break;
				}
				if(map[i][j]=='^') {
					x=i;
					y=j;
					direction='U';
					break;
				}
				if(map[i][j]=='v') {
					x=i;
					y=j;
					direction='D';
					break;
				}
			}
		}
		
		for(int idx=0; idx<cmd.length; idx++) {
			int[] newXY = new int[2];
			switch(cmd[idx]) {
			case 'S':
				shoot(x, y, direction);
				break;
			case 'U':
				direction = 'U';
				newXY = move(x, y, direction);
				x = newXY[0];
				y = newXY[1];
				break;
			case 'D':
				direction = 'D';
				newXY = move(x, y, direction);
				x = newXY[0];
				y = newXY[1];
				break;
			case 'R':
				direction = 'R';
				newXY = move(x, y, direction);
				x = newXY[0];
				y = newXY[1];
				break;
			case 'L':
				direction = 'L';
				newXY = move(x, y, direction);
				x = newXY[0];
				y = newXY[1];
				break;
			}
			
		}
	}
	
	public static void shoot(int x, int y, char direction) {
		switch(direction) {
		case 'U':
			for(int i=x-1; i>=0; i--) {
				if(map[i][y]=='*' || map[i][y]=='#') {
					if(map[i][y]=='*') map[i][y]='.';
					break;
				}
			}
			break;
		case 'D':
			for(int i=x+1; i<H; i++) {
				if(map[i][y]=='*' || map[i][y]=='#') {
					if(map[i][y]=='*') map[i][y]='.';
					break;
				}
			}
			break;
		case 'L':
			for(int i=y-1; i>=0; i--) {
				if(map[x][i]=='*' || map[x][i]=='#') {
					if(map[x][i]=='*') map[x][i]='.';
					break;
				}
			}
			break;
		case 'R':
			for(int i=y+1; i<W; i++) {
				if(map[x][i]=='*' || map[x][i]=='#') {
					if(map[x][i]=='*') map[x][i]='.';
					break;
				}
			}
			break;
		}
	}
	
	public static int[] move(int x, int y, char direction) {
		int[] newXY = {x, y};
		switch(direction) {
		case 'U':
			if(x-1>=0 && map[x-1][y]=='.') {
				map[x-1][y]='^';
				map[x][y]='.';
				newXY[0] = x-1;
			}else {
				map[x][y]='^';
			}
			break;
		case 'D':
			if(x+1<H && map[x+1][y]=='.') {
				map[x+1][y]='v';
				map[x][y]='.';
				newXY[0] = x+1;
			}else {
				map[x][y]='v';
			}
			break;
		case 'L':
			if(y-1>=0 && map[x][y-1]=='.') {
				map[x][y-1]='<';
				map[x][y]='.';
				newXY[1] = y-1;
			}else {
				map[x][y]='<';
			}
			break;
		case 'R':
			if(y+1<W && map[x][y+1]=='.') {
				map[x][y+1]='>';
				map[x][y]='.';
				newXY[1] = y+1;
			}else {
				map[x][y]='>';
			}
			break;
		}
		
		return newXY;
	}
}
