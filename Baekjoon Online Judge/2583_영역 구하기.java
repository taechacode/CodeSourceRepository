package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int M, N, K;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] map;
	static int count = 0;
	static ArrayList<Integer> list = new ArrayList<Integer>();;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int a = y1; a < y2; a++) {
				for(int b = x1; b < x2; b++) {
					map[a][b] = 1;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					count = 0;
					DFS(i, j);
					list.add(count);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
				
	}
	
	private static void DFS(int r, int c) {
		
		map[r][c] = 1;
		count++;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] == 0) {
				DFS(nr, nc);
			}
		}
		
	}
	
}
