package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, answer = 1;
	static int[][] map;
	static boolean[][] flood;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());		
		map = new int[N][N];
		
		// 지역의 높이 정보 입력 받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		// 가장 낮은 침수 높이부터 가장 높은 침수 높이까지 순회
		for(int height = min; height <= max; height++) {
			
			// 현재 침수 높이에서 침수되는 건물 표시 (true로 표기)
			flood = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] <= height) {
						flood[i][j] = true;
					}
				}
			}
			
			// 침수되지 않는 영역의 개수 구하기
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(flood[i][j] == false) {
						dfs(i, j); // 하나의 영역 탐색
						count++;
					}
				}
			}
			
			answer = Math.max(answer, count);
			
		}
		
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y) {
		
		flood[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(flood[nx][ny] == false) {
					dfs(nx, ny);
				}					
			}
		}
		
	}
	
}
