import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		
		int current = 0;
		int result = 0;
		
		for(int divisor = 1; divisor <= N; divisor++) {
			
			if(N % divisor == 0) {
				current += 1;
			}
			
			if(current == K) {
				result = divisor;
				break;
			}
		}
		
		
		System.out.println(result);
	}
	
}