package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static int x, y;
	static int[][] array = new int[101][101];
	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 색종이의 수 입력하기
		int T = Integer.parseInt(br.readLine());
		
		// 색종이의 수만큼 for문 반복
		for(int paper = 0; paper < T; paper++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			// 색종이의 크기가 10이므로 입력값의 10을 더한 범위까지 1로 도화지(배열)를 채움
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					array[i][j] = 1;
				}
			}
		}
		
		// 모든 배열 범위를 탐색
		int answer = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				
				// 만약 1로 되어 있는 경우 색종이를 붙인 범위이므로 탐색
				if (array[i][j] == 1) {
					
					// 해당 색종이 배열을 기준으로 상하좌우 4방향 탐색
					for (int k = 0; k < 4; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						
						// 만약 탐색한 범위가 전체 배열 범위를 벗어나거나 0으로 되어있을 경우
						// 해당 범위는 색종이의 경계라는 뜻이므로 answer 값을 증가시켜줌
						if(ni < 0 || nj < 0 || ni > 101 || nj > 101 || array[ni][nj] == 0) {
							answer++;
						}
						// 증가시키고 바로 탈출하지 않는 이유는 만약 모서리에 있는 배열일 경우
						// 적어도 2개의 면을 둘레의 값으로 더해주어야 하고,
						// 그러기 위해서는 각각 범위를 벗어나거나 0으로 배열에 표기되어 있는 부분을
						// 전체 둘레의 길이 answer에 더해주어야 정상적인 출력이 됨.
					}
				}

			}
		}
		
		System.out.println(answer);
	}
}