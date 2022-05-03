package Baekjoon;

/*
1. 첫번째 열에서 하나씩 값을 증가시키면서 탐색을 시작한다.
2. 마지막 열에 도착하면 탐색을 종료한다. (재귀 종료 조건)
3. 탐색을 한 칸은 x로 표기한다.
*/

import java.io.*;
import java.util.*;

public class Main {	
	static BufferedReader br;
	static StringTokenizer st;
	static int R, C, answer;
	static String[][] array;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		array = new String[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				array[i][j] = String.valueOf(str.charAt(j));
			}
		}
		
		for(int i = 0; i < R; i++) {
			if(search(i, 0))
				// 끝까지 (마지막 열까지) 탐색을 했을 경우 answer 증가
				answer++;
		}
		
		System.out.println(answer);
	}
	
	public static boolean search(int r, int c) {
		
		// 탐색을 한 곳에는 x 표기를 하여 다음 재귀 때 탐색 불가능하도록 지정
		array[r][c] = "x";
		
		if(c == C - 1) { // 만약 빵집에 도착하면 재귀를 종료
			return true;
		}
		
		// 오른쪽 위가 비어있으면 탐색
		if(r > 0 && array[r - 1][c + 1].equals(".")) {
			if(search(r - 1, c + 1))
				return true;
		}
		
		// 오른쪽 옆이 비어있으면 탐색
		if(array[r][c + 1].equals(".")) {
			if(search(r, c + 1))
				return true;
		}
		
		// 오른쪽 아래가 비어있으면 탐색
		if(r + 1 < R && array[r + 1][c + 1].equals(".")) {
			if(search(r + 1, c + 1))
				return true;
		}
		
		// x 표기가 되어있거나 탐색하고자 하는 방향이 배열 범위를 벗어나면 false (탐색 불가능 처리)
		return false;
	}
}
