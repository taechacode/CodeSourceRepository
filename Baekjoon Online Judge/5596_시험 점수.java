package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = 0;
		for(int i = 0; i < 4; i++) {
			S += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int T = 0;
		for(int i = 0; i < 4; i++) {
			T += Integer.parseInt(st.nextToken());
		}
		
		int result = Integer.MIN_VALUE;
		result = Math.max(S, T);
		
		System.out.println(result);
	}
}