package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 5; i++) {
			sb.append(Integer.parseInt(st.nextToken()) - (L * P)).append(" ");
		}
		
		System.out.println(sb);
	}
}