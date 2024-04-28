import java.io.*;
import java.util.*;

class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static boolean[][] field;
	static boolean[][] visited;
	
	static int[] dirX = {-1, 1, 0, 0};
	static int[] dirY = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 0; testCase < T; testCase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new boolean[M + 1][N + 1];
			visited = new boolean[M + 1][N + 1];
			
			for(int cabbage = 0; cabbage < K; cabbage++) {
				st = new StringTokenizer(br.readLine());
				field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			int answer = 0;
			for(int searchX = 0; searchX < M; searchX++) {
				for(int searchY = 0; searchY < N; searchY++) {
					if(field[searchX][searchY] && !visited[searchX][searchY]) {
						DFS(searchX, searchY, M, K);
						answer++;
					}					
				}
			}
			
			sb.append(answer).append("\n");
		}		
		
		System.out.println(sb.toString());
	}
	
	
	private static void DFS(int X, int Y, int M, int K) {
		
		visited[X][Y] = true;
		
		for(int dir = 0; dir < 4; dir++) {
			
			int nextX = X + dirX[dir];
			int nextY = Y + dirY[dir];
			
			if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < K) {
				if(field[nextX][nextY] && !visited[nextX][nextY]) {
					DFS(nextX, nextY, M, K);
				}				
			}
			
		}
		
	}
}