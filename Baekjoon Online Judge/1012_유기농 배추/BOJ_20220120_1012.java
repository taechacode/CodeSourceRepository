import java.io.*;
import java.util.*;

public class Main {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean arr[][];
	static boolean check[][];
	static int m, n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int testCount = Integer.parseInt(br.readLine());
		int answer;
		
		for(int i = 0; i < testCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			arr = new boolean[n][m];
			check = new boolean[n][m];
			
			answer = 0;
			
			for(int j = 0; j < count; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = true;
			}
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(checkLocation(j, k)) {
						answer++;
						dfs(j, k);
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean checkLocation(int row, int col) {
		if(row < 0 || row >= n || col < 0 || col >= m)
			return false;
		if(check[row][col] == true || arr[row][col] == false)
			return false;
		return true;
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true;
		if(checkLocation(x+1, y))
			dfs(x+1, y);
		if(checkLocation(x, y+1))
			dfs(x, y+1);
		if(checkLocation(x-1, y))
			dfs(x-1, y);
		if(checkLocation(x, y-1))
			dfs(x, y-1);
	}
}