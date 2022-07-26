package Baekjoon;

import java.io.*;
import java.util.*;

// 말의 위치 정보를 가지는 클래스
class Pos {
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int I, count;
	static boolean[][] visited;
	
	// 나이트가 현재 위치로부터 이동할 수 있는 8가지 방향
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws Exception {
		
		int test = Integer.parseInt(br.readLine());
		
		for(int iterCount = 0; iterCount < test; iterCount++) {			
			
			I = Integer.parseInt(br.readLine());
			visited = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			Pos current = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			Pos knight = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			count = 0;
			bfs(current, knight);
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void bfs(Pos current, Pos knight) {
		// 만약 현재 말의 위치와 목적지 말의 위치가 같다면 bfs 바로 종료
		if(current.x == knight.x && current.y == knight.y) {
			return;
		}
		
		Queue<Pos> queue = new LinkedList<>();
		visited[current.x][current.y] = true;
		queue.add(current);
		
		while(!queue.isEmpty()) {
			
			// 몇 번 이동해야하는지 세기 위하여 queue의 크기만큼 반복
			int size = queue.size();			
			for(int i = 0; i < size; i++) {
				
				Pos next = queue.poll();
				
				for(int j = 0; j < 8; j++) {
					int nx = next.x + dx[j];
					int ny = next.y + dy[j];
					
					// 체스판 좌표 범위 내에 있고, 방문하지 않은 좌표인지 검사
					if(nx >= 0 && ny >= 0 && nx < I && ny < I && !visited[nx][ny]) {
						// 만약 목적지와 좌표가 같다면 bfs 함수 종료
						if(nx == knight.x && ny == knight.y) {
							count++;
							return;
						} else { // 만약 목적지 좌표가 아니라면 다음 탐색을 위해 queue에 좌표 저장
							visited[nx][ny] = true;
							queue.add(new Pos(nx, ny));
						}
					}
				}
			}
			
			count++;
		}
	}
	
}
