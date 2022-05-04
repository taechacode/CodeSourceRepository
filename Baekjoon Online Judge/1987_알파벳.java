package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {	
	static BufferedReader br;
	static StringTokenizer st;
	static int R, C, answer, count = 1;
	static char[][] array;
	static boolean[] isSelected;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		array = new char[R][C];
		isSelected = new boolean[26];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			array[i] = str.toCharArray();
		}
		
		search(0, 0, 0);
		System.out.println(answer);
	}
	
	public static void search(int r, int c, int count) {
		
		// 만약 방문을 한 좌표라면
		if(isSelected[array[r][c] - 65]) {
			
			// 해당 좌표까지의 count값과 기존 answer 값을 비교해서 큰 값을 answer에 넣어줌
			answer = Math.max(answer, count);
			
			// 이전 좌표로 이동
			return;
		}
		
		else {
			
			// 현재 좌표를 방문했음으로 처리
			isSelected[array[r][c] - 65] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];
				
				// 4방향 탐색 좌표가 배열 범위 안에 있을 경우 해당 좌표로 탐색
				if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
					search(nx, ny, count + 1);
				}
			}
			
			// 탐색했었던 경로가 잘못되었을 경우를 대비해 방문했던 좌표를 미방문으로 바꿔줌
			isSelected[array[r][c] - 65] = false;
		}
		
	}
}
