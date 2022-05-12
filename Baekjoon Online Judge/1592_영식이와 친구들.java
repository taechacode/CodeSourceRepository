package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		
		int count = 0;
		int index = 0;
		
		// 어떤 사람이든 공을 받은 횟수가 M이 되면 공 던지기를 멈춘다.
		while(array[index] != M) {
			
			// 만약 현재 공을 받은 사람이 공을 받았던 횟수가 홀수라면
			if(array[index] % 2 == 1) {
				if(index + L > N - 1) {
					index = (index + L) % N;
				}
				else {
					index = index + L;
				}
			}
			
			// 만약 현재 공을 받은 사람이 공을 받았던 횟수가 짝수라면
			else if(array[index] % 2 == 0) {
				if (index - L < 0) {
					index = N - Math.abs(index - L);
				}
				else {
					index = index - L;
				}
			}
			
			count++;
			array[index]++;
		}
		
		count--;
		System.out.println(count);
	}
}