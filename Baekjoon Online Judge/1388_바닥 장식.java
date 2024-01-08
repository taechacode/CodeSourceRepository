
import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, count;
	
	static String[][] map;
	static boolean[][] visited;
			
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new String[N][M];
		visited = new boolean[N][M];
		String line;
		
		for(int row = 0; row < N; row++) {
			line = br.readLine();
			for(int col = 0; col < M; col++) {
				map[row][col] = line.substring(col, col + 1);
			}
		}
		
		count = 0;
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(!visited[row][col]) {
					DFS(row, col);
					count++;
				}				
			}
		}
		
		System.out.println(count);
		
	}
	
	private static void DFS(int row, int col) {
		
		visited[row][col] = true;
		
		if(map[row][col].equals("-")) {
			if(col + 1 < M && map[row][col + 1].equals("-") && !visited[row][col + 1]) {
				DFS(row, col + 1);
			}		
			return;
		}
		
		if(map[row][col].equals("|")) {
			if(row + 1 < N && map[row + 1][col].equals("|") && !visited[row + 1][col]) {
				DFS(row + 1, col);
			}		
			return;
		}
		
	}
			
}
