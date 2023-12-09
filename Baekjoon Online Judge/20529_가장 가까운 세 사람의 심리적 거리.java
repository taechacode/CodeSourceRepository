
import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());		
		for(int i = 0; i < T; i++) {
			
			int min = Integer.MAX_VALUE;
			
			int N = Integer.parseInt(br.readLine());
			String[] MBTI = new String[N];			
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				MBTI[j] = st.nextToken();
			}
			
			min = check(MBTI, N, min);
			
			sb.append(min).append("\n");
		}
		
		System.out.println(sb.toString());		
	}
	
	private static int check(String[] MBTI, int N, int min) {
		
		for(int j = 0; j < N - 2; j++) {
			for(int k = j + 1; k < N - 1; k++) {
				for(int l = k + 1; l < N; l++) {
					min = Math.min(min, comp(MBTI[j], MBTI[k]) + comp(MBTI[j], MBTI[l]) + comp(MBTI[k], MBTI[l]));
				}
				if(min == 0) return min;
			}
			if(min == 0) return min;
		}
		
		return min;
	}
	
	private static int comp(String MBTI1, String MBTI2) {
		
		int distance = 0;
		for(int i = 0; i < 4; i++) {
			if(MBTI1.charAt(i) != (MBTI2.charAt(i))) {
				distance++;
			}
		}
		
		return distance;
	}
		
}
