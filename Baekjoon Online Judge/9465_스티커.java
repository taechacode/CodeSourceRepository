
import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[][] map; 
	static int[][] dp;
	
	static int T, N;
		
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int testCase = 0; testCase < T; testCase++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[2][N + 1];
			dp = new int[2][N + 1];
			
			for(int row = 0; row < 2; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col = 1; col <= N; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			
			for(int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];
			}
			
			sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
			
}
