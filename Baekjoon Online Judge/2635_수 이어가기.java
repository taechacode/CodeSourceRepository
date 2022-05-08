package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, max, maxNum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		max = Integer.MIN_VALUE;
		
		// 1부터 처음에 주어지는 n까지 모든 경우의 수를 구해봄
		for(int i = 1; i <= n; i++) {
			findMax(i);
		}
		
		System.out.println(max);
		printMax(maxNum);
	}
	
	// 최장 길이가 얼마인지 구하는 findMax 메소드
	private static void findMax(int input) {
		int prenum = input; // 이전수
		int preprenum = n; // 이전이전수
		
		// 처음에 숫자 2개는 무조건 주어지므로 2로 count를 초기화
		int count = 2;
		
		// 이전 수가 0 이상이 될 때까지 반복
		while(prenum >= 0) {
			int temp = prenum;
			prenum = preprenum - prenum;
			preprenum = temp;
			count++;
		}
		
		// 첫번째 음수가 나올 때까지 count를 증가시켰으므로 마지막에는 하나를 빼준다
		count--;
		
		// 최장 길이와 최장 길이일 때의 2번째 수를 갱신
		if(count > max) {
			max = count;
			maxNum = input;
		}
	}
	
	// 최장 길이 수열을 출력하는 printMax 메소드
	private static void printMax(int input) {
		int prenum = input; // 이전수
		int preprenum = n; // 이전이전수
		
		System.out.print(preprenum + " " + prenum + " ");
		
		while(prenum >= 0) {
			int temp = prenum;
			prenum = preprenum - prenum;
			preprenum = temp;
			
			if(prenum >= 0)
				System.out.print(prenum + " ");
		}
	}
}