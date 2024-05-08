import java.io.*;
import java.util.*;

	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int computer, pair;
	static boolean[][] network;
	static boolean[] visited;
		
	public static void main(String[] args) throws IOException {
		
		computer = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		network = new boolean[computer + 1][computer + 1];
		visited = new boolean[computer + 1];
		
		for(int p = 0; p < pair; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			network[from][to] = network[to][from] = true;
		}
		
		virus(1);
		
		int answer = -1;
		for(int v = 1; v < visited.length; v++) {
			if(visited[v]) answer++;
		}
		
		
		System.out.println(answer);
	}
	
	private static void virus(int start) {
		
		visited[start] = true;
		
		for(int i = 1; i <= computer; i++) {
			if(network[start][i] && !visited[i]) {
				virus(i);
			}
		}
		
	}
	
}