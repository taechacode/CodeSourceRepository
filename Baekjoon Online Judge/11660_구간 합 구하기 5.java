
import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[][] map; 
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		
		for(int row = 1; row <= N; row++) {	
			st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());		
				dp[row][col] += dp[row][col - 1] + map[row][col];
			}
		}
		
		int x1, x2, y1, y2, sum;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sum = 0;
			
			for(int row = x1; row <= x2; row++) {
				sum += dp[row][y2] - dp[row][y1 - 1];
			}

			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
		
}
