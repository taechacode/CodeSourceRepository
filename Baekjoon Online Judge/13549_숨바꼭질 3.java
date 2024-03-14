
import java.io.*;
import java.util.*;

class HideAndSeek {
	
	int position;
	int time;
	
	HideAndSeek(int position, int time) {
		this.position = position;
		this.time = time;
	}
	
}

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<HideAndSeek> queue = new LinkedList<>();
		queue.add(new HideAndSeek(N, 0));
		
		int answer = Integer.MAX_VALUE;
		HideAndSeek current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			visited[current.position] = true;
			
			if(current.position == K) {
				answer = Math.min(answer, current.time);
			}
			
			if(current.position - 1 >= 0 && !visited[current.position - 1]) queue.add(new HideAndSeek(current.position - 1, current.time + 1));
			if(current.position + 1 <= 100000 && !visited[current.position + 1]) queue.add(new HideAndSeek(current.position + 1, current.time + 1));
			if(current.position * 2 <= 100000 && !visited[current.position * 2]) queue.add(new HideAndSeek(current.position * 2, current.time));	
					
		}
		
		System.out.println(answer);
	}
	
}
