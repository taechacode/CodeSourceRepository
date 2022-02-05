package SSAFY;

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}, dd[] = {0, 1, 2, 3};

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int teseCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= teseCase; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[N][N];
			int n = 1, x = 0, y = 0, d = 0;
			
			while(n <= N * N) {
				int X = x + dx[dd[d]], Y = y + dy[dd[d]];
				if(X < 0 || X >= N || Y < 0 || Y >= N || arr[X][Y] != 0) { 
					d = (d + 1) % 4; 
					X = x + dx[dd[d]]; Y = y + dy[dd[d]];
				}
				
				arr[x][y] = n++;
				x = X; y = Y;
			}
			
			sb.append("#" + i).append("\n");
			
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					sb.append(arr[j][k] + " ");
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
}
