
import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M;
	static int[] inputArray;
	static int[] outputArray;
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inputArray = new int[N];	
		outputArray = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputArray);
		
		search(0, 0);
		
		System.out.println(sb.toString());
	}
	
	private static void search(int current, int depth) {
		
		if(depth == M) {
			for(int input : outputArray) {
				sb.append(input).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = current; i < N; i++) {
			outputArray[depth] = inputArray[i];
			search(i, depth + 1);
		}
				
	}
	
}
