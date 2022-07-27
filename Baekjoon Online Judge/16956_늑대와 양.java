package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int R, C;
	static String[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().split("");
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				
				if(map[r][c].equals("W")) {
					
					for(int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if(nr >= 0 && nc >= 0 && nr < R && nc < C) {
							// 양이 늑대한테 접근할 수 없게끔 늑대 주변에 울타리 설치
							if(map[nr][nc].equals(".")) {
								map[nr][nc] = "D";
							}
							// 만약 양과 늑대가 맞닿아 있으면 막을 방법이 없으므로 0 출력
							else if(map[nr][nc].equals("S")) {
								System.out.println(0);
								return;
							}
						}
						
					}
				}
				
			}
		}
		
		sb.append(1).append("\n");
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
		
}
