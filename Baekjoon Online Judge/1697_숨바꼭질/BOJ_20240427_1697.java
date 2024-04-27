import java.io.*;
import java.util.*;

class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	
	// Q. visited�� boolean�� �ƴ� int������ �������� �����ϴ� ����?
	// A. �Ʒ��� BFS Ž�� ���������� Ž�� ȸ������ �ð��� �󸶳� �������� boolean�����δ� Ȯ���ϱ� �����.
	// Ž�� ȸ������ �ð��� �����ϱ� ���� �������� �ش� ��ġ�� �湮���� �� ����.
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
			
			// 1. x - 1�� ��� ������ check�ϰ�, �̹湮 ��ġ��� queue�� ����
			if(currentPos - 1 >= 0 && currentPos - 1 < 100001 && visited[currentPos - 1] == 0) {
				queue.add(currentPos - 1);
				visited[currentPos - 1] = visited[currentPos] + 1;
			}
			
			// 2. x + 1�� ��� ������ check�ϰ�, �̹湮 ��ġ��� queue�� ����
			if(currentPos + 1 >= 0 && currentPos + 1 < 100001 && visited[currentPos + 1]== 0) {
				queue.add(currentPos + 1);
				visited[currentPos + 1] = visited[currentPos] + 1;
			}
			
			// 3. x * 2�� ��� ������ check�ϰ�, �̹湮 ��ġ��� queue�� ����
			if(currentPos * 2 >= 0 && currentPos * 2 < 100001 && visited[currentPos * 2] == 0) {
				queue.add(currentPos * 2);
				visited[currentPos * 2] = visited[currentPos] + 1;
			}
		}
		
		System.out.println(visited[currentPos]);

	}
}