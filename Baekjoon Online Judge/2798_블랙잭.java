package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					int sum = 0;
					sum = array[i] + array[j] + array[k];
					if(sum <= M) {
						max = Math.max(max, sum);
					}
				}
			}
		}
		
		System.out.println(max);
	}
}