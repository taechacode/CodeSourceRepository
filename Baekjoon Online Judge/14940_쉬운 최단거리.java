
import java.io.*;
import java.util.*;

// Queue에 담기 위한 좌표 클래스 Pos
class Pos {
	
	int X;
	int Y;
	
	Pos(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
	
}

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[][] inputBoard; // 입력받을 배열
	static int[][] outputBoard; // 출력할 배열
	static boolean[][] visited; // 방문 표시하는 배열
	static int n, m, startX, startY; // 보드 가로 n, 보드 세로 m, 시작점 X좌표 startX, 시작점 Y좌표 startY
	// 상하좌우로 탐색할 때 사용할 X, Y 좌표
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		inputBoard = new int[n][m];
		outputBoard = new int[n][m];
		visited = new boolean[n][m];
		
		for(int row = 0; row < n; row++) {			
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < m; col++) {
				inputBoard[row][col] = Integer.parseInt(st.nextToken());
				if(inputBoard[row][col] == 2) { // 유일하게 inputBoard에서 2로 표시된 지점이 탐색 출발점
					startX = row;
					startY = col;
				}
			}
		}
				
		BFS(startX, startY);
				
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < m; col++) {
				if(inputBoard[row][col] == 1 && visited[row][col] == false) {
					System.out.print(-1 + " ");
				} else {
					System.out.print(outputBoard[row][col] + " ");
				}				
			}
			System.out.println();
		}
	}
	
	private static void BFS(int x, int y) {
		
		Queue<Pos> queue = new LinkedList<>();
		
		queue.offer(new Pos(x, y));
		outputBoard[x][y] = 0;
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			
			Pos currentPos = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = currentPos.X + dirX[i];
				int nextY = currentPos.Y + dirY[i];
				
				if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
					if(!visited[nextX][nextY] && inputBoard[nextX][nextY] != 2 && inputBoard[nextX][nextY] != 0) {
						outputBoard[nextX][nextY] = outputBoard[currentPos.X][currentPos.Y] + 1;
						visited[nextX][nextY] = true;
						queue.offer(new Pos(nextX, nextY));
					}					
				}
				
			}
			
		}
		
	}
	
}
