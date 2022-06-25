package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static int H, Y;
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		dp = new long[Y + 1];
		dp[0] = H;
		
		recursion(1);
				
		System.out.println(dp[Y]);
	}
	
	public static void recursion(int cnt) {
		if(cnt > Y) {
			return;
		}

		dp[cnt] = (int)(dp[cnt - 1] * 1.05);
		
		if(cnt >= 3) {
			dp[cnt] = Math.max(dp[cnt], (int)(dp[cnt - 3] * 1.2));
		}
		
		if(cnt >= 5) {
			dp[cnt] = Math.max(dp[cnt], (int)(dp[cnt - 5] * 1.35));
		}
		
		recursion(cnt + 1);
	}
}