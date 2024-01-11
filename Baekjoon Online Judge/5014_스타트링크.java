
import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] visited;
	static int[] count;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken()) - 1;
		int G = Integer.parseInt(st.nextToken()) - 1;
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		if((S > G && D == 0) || (S < G && U == 0)) {
			System.out.println("use the stairs");
			return;
		}
		
		visited = new boolean[F];
		count = new int[F];
		int current = S;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(current);
		visited[current] = true;
		
		while(!queue.isEmpty()) {
			
			current = queue.poll();			
			
			if(current == G) {
				break;
			}
			
			if(current + U < F && !visited[current + U]) {
				queue.add(current + U);
				visited[current + U] = true;
				count[current + U] = count[current] + 1;
			}
				
			if(current - D >= 0 && !visited[current - D]) {
				queue.add(current - D);
				visited[current - D] = true;
				count[current - D] = count[current] + 1;
			}
			
		}
		
		if(current != G) {
			System.out.println("use the stairs");
		} else {
			System.out.println(count[current]);
		}
		
	}
			
}
