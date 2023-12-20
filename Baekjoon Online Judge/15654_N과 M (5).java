
import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M;
	static int[] inputArray;
	static int[] outputArray;
	static boolean[] visited;
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inputArray = new int[N];
		outputArray = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputArray);
		
		DFS(0);
		
		System.out.println(sb.toString());
	}
	
	private static void DFS(int depth) {
		
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(outputArray[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				outputArray[depth] = inputArray[i];
				DFS(depth + 1);
				visited[i] = false;
			}
		}
		
	}
	
}
