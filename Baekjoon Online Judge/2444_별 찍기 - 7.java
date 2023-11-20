
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			
			for(int spaceCount = 0; spaceCount < N - i; spaceCount++) {
				sb.append(" ");
			}
			
			for(int starCount = 0; starCount < (i * 2 - 1); starCount++) {
				sb.append("*");
			}
			
			sb.append("\n");
			
		}
		
		for(int i = 1; i <= N - 1; i++) {
			
			for(int spaceCount = 0; spaceCount < i; spaceCount++) {
				sb.append(" ");
			}
			
			for(int starCount = 0; starCount < ((N - i) * 2 - 1); starCount++) {
				sb.append("*");
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
}
