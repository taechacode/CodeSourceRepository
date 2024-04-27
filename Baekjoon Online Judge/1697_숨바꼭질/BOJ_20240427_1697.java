import java.io.*;
import java.util.*;

class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	
	// Q. visited를 boolean이 아닌 int형으로 정수값을 저장하는 이유?
	// A. 아래의 BFS 탐색 구조에서는 탐색 회차별로 시간이 얼마나 지났는지 boolean형으로는 확인하기 어려움.
	// 탐색 회차별로 시간을 관리하기 위해 정수값을 해당 위치에 방문했을 때 기입.
	static int[] visited = new int[100001];
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		String K = st.nextToken();
		
		int currentPos = Integer.parseInt(N);
		int goalPos = Integer.parseInt(K);		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(currentPos);
		visited[currentPos] = 0;
		
		while(!queue.isEmpty()) {
			currentPos = queue.poll();			
			
			if(currentPos == goalPos) {
				break;
			}
			
			// 1. x - 1일 경우 범위를 check하고, 미방문 위치라면 queue에 삽입
			if(currentPos - 1 >= 0 && currentPos - 1 < 100001 && visited[currentPos - 1] == 0) {
				queue.add(currentPos - 1);
				visited[currentPos - 1] = visited[currentPos] + 1;
			}
			
			// 2. x + 1일 경우 범위를 check하고, 미방문 위치라면 queue에 삽입
			if(currentPos + 1 >= 0 && currentPos + 1 < 100001 && visited[currentPos + 1]== 0) {
				queue.add(currentPos + 1);
				visited[currentPos + 1] = visited[currentPos] + 1;
			}
			
			// 3. x * 2일 경우 범위를 check하고, 미방문 위치라면 queue에 삽입
			if(currentPos * 2 >= 0 && currentPos * 2 < 100001 && visited[currentPos * 2] == 0) {
				queue.add(currentPos * 2);
				visited[currentPos * 2] = visited[currentPos] + 1;
			}
		}
		
		System.out.println(visited[currentPos]);

	}
}