package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, K, count, max = Integer.MIN_VALUE;
	static boolean[][] map, visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				
				if(map[r][c] && !visited[r][c]) {
					count = 1;
					visited[r][c] = true;
					dfs(r, c);
					max = Math.max(max, count);
				}
				
			}
		}
		
		System.out.println(max);
	}
	
	private static void dfs(int r, int c) {
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if(map[nr][nc] && !visited[nr][nc]) {
					count++;
					visited[nr][nc] = true;
					dfs(nr, nc);
				}
			}
		}
		
	}
		
}
