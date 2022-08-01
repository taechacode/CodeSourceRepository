package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] relation;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 0; testCase < T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			relation = new int[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				relation[i] = Integer.parseInt(st.nextToken()) - 1;
			}
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				if(!visited[i]) {
					dfs(i);
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());		
	}
	
	private static void dfs(int start) {
		
		visited[start] = true;
		if(!visited[relation[start]]) {
			dfs(relation[start]);
		}
		
	}
			
}
