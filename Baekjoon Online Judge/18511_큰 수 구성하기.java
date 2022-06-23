package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] nums;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		dfs(0);
		
		System.out.println(answer);
	}
	
	public static void dfs(int now) {
		if(now > N)
			return;
		
		if(now > answer)
			answer = now;
		
		for(int i = K - 1; i >= 0; i--) {
			dfs(now * 10 + nums[i]);
		}
	}
}