import java.io.*;
import java.util.*;

class Graph {
	private int N;
	private int[][] graph;
	private boolean[] visited;
	private int count;
	
	public Graph(int N) {
		this.N = N;
		this.graph = new int[this.N+1][this.N+1];
		this.visited = new boolean[this.N+1];
	}
	
	public void put(int x, int y) {
		this.graph[x][y] = this.graph[y][x] = 1;
	}
	
	public void clearGraph() {
		for(int i = 0; i < this.visited.length; i++) {
			this.visited[i] = false;
		}
	}
	
	public void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		this.visited[V] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int i = 1; i <= this.N; i++) {
				if(this.graph[x][i] == 1 && this.visited[i] == false) {
					queue.add(i);
					this.visited[i] = true;
				}
			}
		}
	}
	
	public void virusCount() {
		this.count = 0;
		for(int i = 0; i < this.visited.length; i++) {
			if(this.visited[i] == true) {
				this.count++;
			}
		}
		System.out.println(--this.count);
	}
}

public class Main {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int computer = Integer.parseInt(br.readLine());
		int relationship = Integer.parseInt(br.readLine());
		
		Graph graph = new Graph(computer);
		for(int i = 0; i < relationship; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			graph.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		graph.bfs(1);
		graph.virusCount();
	}
}