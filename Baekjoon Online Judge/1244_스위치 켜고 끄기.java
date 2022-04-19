package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, student;
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		student = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int num = 0;
			
			switch(Integer.parseInt(st.nextToken())) {
			
			// 남학생일 경우
			case 1:
				num = Integer.parseInt(st.nextToken());
				
				// 해당 입력 수와 수의 배수들을 모두 반전시킴
				// 단, 배열은 0부터 시작하고 스위치 번호는 1부터 시작함에 유의하기
				for(int j = num - 1; j < N; j += num) {
					if(array[j] == 1) {
						array[j] = 0;
					}
					else {
						array[j] = 1;
					}
				}
				
				break;
			
			// 여학생일 경우
			case 2:
				num = Integer.parseInt(st.nextToken()) - 1;
				int limit = Math.min(Math.abs((N - 1) - num), num);
				int pos = 0;
				
				// 어디까지 대칭 구조로 되어있는지 검사
				for(int j = 1; j <= limit; j++) {
					if(array[num+j] != array[num-j]) {
						pos = j - 1;
						break;
					}
					pos = j;
				}
				
				// 대칭된 부분의 첫 부분부터 끝 부분까지 모두 스위치 반전시키기
				for(int j = num - pos; j <= num + pos; j++) {
					if(array[j] == 1) {
						array[j] = 0;
					}
					else {
						array[j] = 1;
					}
				}
				
				break;
			}
		}
		
		sb = new StringBuilder();
		
		// 조건에 1줄에 스위치 상태를 20개씩 출력한다고 되어 있음
		for(int i = 0; i < N; i++) {
			if(i % 20 == 0) {
				sb.append("\n");
			}
			sb.append(array[i]).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
