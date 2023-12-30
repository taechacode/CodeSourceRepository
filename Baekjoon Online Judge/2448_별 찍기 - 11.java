
import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static char[][] star = {{' ', ' ', '*', ' ', ' '}, {' ', '*', ' ', '*', ' '}, {'*', '*', '*', '*', '*'}};
	static char[][] map = new char[3500][6500];
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		stamp(N / 3, 0, 0);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N * 2 - 1; j++) {
				sb.append(map[i][j] == '*' ? '*' : ' ');
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void stamp(int n, int x, int y) {
		
		if(n == 1) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 5; j++) {
					map[i + x][j + y] = star[i][j];
				}
			}
			return;
		}
		
		stamp(n / 2, x, y + 3 * n / 2);
		stamp(n / 2, x + 3 * n / 2, y);
		stamp(n / 2, x + 3 * n / 2, y + 3 * n);
		
	}
	
}
