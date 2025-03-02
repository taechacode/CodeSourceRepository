import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	
	static int[] input, result;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int index = 0; index < N; index++) {
			input[index] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		calcNumSeq(0, 0);
		System.out.println(sb.toString());
	}
	
	
	private static void calcNumSeq(int depth, int start) {
		
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		for(int i = start; i < N; i++) {
			if(prev != input[i]) {
				result[depth] = input[i];
				prev = input[i];
				calcNumSeq(depth + 1, i);
			}
		}
		
	}
	
}
