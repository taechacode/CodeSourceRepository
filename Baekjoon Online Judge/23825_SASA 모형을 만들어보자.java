package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = N / 2;
		
		int M = Integer.parseInt(st.nextToken());
		int A = M / 2;
		
		System.out.println(Math.min(S, A));
	}
}