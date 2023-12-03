
import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int T = Integer.parseInt(br.readLine());
		int C, Q, D, N, P;
		
		for(int i = 0; i < T; i++) {
			
			C = Integer.parseInt(br.readLine());
			
			Q = C / 25;
			C -= Q * 25;
			
			D = C / 10;
			C -= D * 10;
			
			N = C / 5;
			C -= N * 5;
			
			P = C / 1;
			C -= P * 1;
			
			sb.append(Q).append(" ").append(D).append(" ").append(N).append(" ").append(P).append(" ").append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
}
