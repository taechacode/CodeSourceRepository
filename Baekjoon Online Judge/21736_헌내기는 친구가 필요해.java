
import java.io.*;
import java.util.*;

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
	
	static int N, M, countP = 0;
	static String[][] map;
	static boolean[][] visited;
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {1, -1, 0, 0};
	static int startX = -1, startY = -1;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new String[N][M];
		visited = new boolean[N][M];
		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			map[row] = st.nextToken().split("");
			
			if(startX == -1 && startY == -1) {
				for(int col = 0; col < M; col++) {
					if(map[row][col].equals("I")) {
						startX = row;
						startY = col;
						break;
					}
				}
			}	
			
		}
				
		searchPerson();
		
		if(countP == 0) {
			System.out.println("TT");
		} else {
			System.out.println(countP);
		}		
		
	}
	
	private static void searchPerson() {
		
		Pos pos = new Pos(startX, startY);
		
		Queue<Pos> queue = new LinkedList<>();	
		queue.add(pos);
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			
			Pos current = queue.poll();
						
			int nextX, nextY;
			for(int i = 0; i < 4; i++) {
				nextX = current.X + dirX[i];
				nextY = current.Y + dirY[i];
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || visited[nextX][nextY]) {
					continue;
				} else {
					if(map[nextX][nextY].equals("O")) {
						visited[nextX][nextY] = true;
						queue.add(new Pos(nextX, nextY));
					}
					if(map[nextX][nextY].equals("P")) {
						visited[nextX][nextY] = true;
						queue.add(new Pos(nextX, nextY));
						countP++;
					}
					if(map[nextX][nextY].equals("X")) {
						visited[nextX][nextY] = true;
					}
				}
			}
			
		}
		
		
	}
	
}
