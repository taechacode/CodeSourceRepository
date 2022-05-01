package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, max = 0;
	static int[][] array;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		array = new int[N][6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
			array[i][2] = Integer.parseInt(st.nextToken());
			
			// 대칭면을 만들기 위해 3번째와 4번째 입력되는 주사위 숫자를 순서를 바꿔서 받아줌
			// 본래는 A와 F, B와 D, C와 E가 서로 대칭면임.
			// 하지만 대칭면을 계산할 때 "5 - 현재면 = 대칭면"과 같은 방식으로
			// 쉽게 계산하기 위해서 D와 E의 숫자 받는 순서를 바꿔줌.
			array[i][4] = Integer.parseInt(st.nextToken());
			array[i][3] = Integer.parseInt(st.nextToken());
			array[i][5] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 6; i++) {
			getMax(array[0][i], 0, 0);
		}
		System.out.println(max);
	}
	
	private static void getMax(int down, int index, int sum) {
		
		// 만약 위로 쌓인 주사위를 모두 탐색했으면
		// 옆면 최대값들의 합 sum과 기존 max 값을 비교하여 큰 값을 max에 넣음
		if(index == N) {
			max = Math.max(sum, max);
			return;
		}
		
		// 매개변수를 통해 아랫면의 숫자를 알고 있으므로
		// 현재 탐색하는 주사위의 윗면을 구함
		int up = 0;
		for(int i = 0; i < 6; i++) {
			if(array[index][i] == down) {
				up = array[index][5 - i];
				break;
			}
		}
		
		// 옆면의 숫자들 중에서 최대값을 담는 변수
		int maxOfSide = 0;
		
		for(int i = 0; i < 6; i++) {
			
			// 만약 윗면이나 아랫면의 숫자일 경우 maxOfSide를 갱신하지 않음
			if(array[index][i] == down || array[index][i] == up) {
				continue;
			}
			maxOfSide = Math.max(maxOfSide, array[index][i]);
		}
		
		// 본래 윗면을 전달인자로 넣어주면
		// 재귀 메소드에서드는 이것을 아랫면 매개변수로 받음.
		getMax(up, index + 1, sum + maxOfSide);
	}
}
