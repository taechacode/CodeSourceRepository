
import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[][] board;
	static int whiteCount;
	static int blueCount;
	
	public static void main(String[] args) throws IOException {
	
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		StringTokenizer st;
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(0, 0, N);
		
		System.out.println(whiteCount);
		System.out.println(blueCount);
		
	}
	
	private static void recursive(int x, int y, int n) {
		
		if(n == 1) {
			if(board[x][y] == 0) {
				whiteCount++;
			} 
			if(board[x][y] == 1){
				blueCount++;
			}
			return;
		}
				
		boolean allWhiteCheck = true;
		boolean allBlueCheck = true;
		
		for(int row = x; row < x + n; row++) {
			for(int col = y; col < y + n; col++) {
				if(board[row][col] != 0) {
					allWhiteCheck = false;
				} 
				if(board[row][col] != 1){
					allBlueCheck = false;
				}
			}
		}
		
		if(allWhiteCheck) {
			whiteCount++;
		} else if(allBlueCheck) {
			blueCount++;
		} else {
			recursive(x, y, n / 2);
			recursive(x + n / 2, y, n / 2);
			recursive(x, y + n / 2, n / 2);
			recursive(x + n / 2, y + n / 2, n / 2);
		}
		
	}
	
}
