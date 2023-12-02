
import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int R, C;
	static String[][] board;
	static boolean[][] visited;
	
	static int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int currentCount;
	static int maxCount;
	
	static HashSet<String> alphabetHistory = new HashSet<String>();
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new String[R][C];
		visited = new boolean[R][C];
		
		for(int row = 0; row < R; row++) {
			board[row] = br.readLine().split("");
		}
		
		currentCount = 0;
		maxCount = 0;
		
		DFS(0, 0);
		
		System.out.println(maxCount);
		
	}
	
	private static void DFS(int row, int col) {
		
		alphabetHistory.add(board[row][col]);
		visited[row][col] = true;
		currentCount++;		
		maxCount = Math.max(maxCount, currentCount);
		
		for(int dir = 0; dir < 4; dir++) {
			
			int nextDirRow = row + direction[dir][0];
			int nextDirCol = col + direction[dir][1];
			
			if(nextDirRow < 0 || nextDirRow >= R || nextDirCol < 0 || nextDirCol >= C) continue;
			
			if(alphabetHistory.contains(board[nextDirRow][nextDirCol])) continue;
			
			DFS(nextDirRow, nextDirCol);
			
		}
		
		currentCount--;
		visited[row][col] = false;
		alphabetHistory.remove(board[row][col]);
		
	}
	
}
