package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int W, H, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dh = {0, 0, 1, -1, -1, 1, -1, 1};
	static int[] dw = {1, -1, 0, 0, -1, 1, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0)
				break;
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
		
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());		
	}
	
	private static void dfs(int h, int w) {
		visited[h][w] = true;
		for(int i = 0; i < 8; i++) {
			int nh = h + dh[i];
			int nw = w + dw[i];
			
			if(nh >= 0 && nw >= 0 && nh < H && nw < W) {
				if(map[nh][nw] == 1 && !visited[nh][nw]) {
					dfs(nh, nw);
				}
			}
		}
	}
	
}
