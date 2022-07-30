package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(B, Collections.reverseOrder());
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer += A[i] * B[i];
		}
		
		System.out.println(answer);
		
	}
			
}
