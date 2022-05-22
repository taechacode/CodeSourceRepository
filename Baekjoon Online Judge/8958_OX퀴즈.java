package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 0; testCase < T; testCase++) {
			int count = 1;
			int sum = 0;
			
			String str = br.readLine();
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'X') {
					count = 1;
					continue;
				}
				sum += count;
				count++;
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}