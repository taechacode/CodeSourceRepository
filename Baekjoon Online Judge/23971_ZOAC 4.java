import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println( (H % (N + 1) > 0 ? H / (N + 1) + 1 : H / (N + 1)) 
				* (W % (M + 1) > 0 ? W / (M + 1) + 1 : W / (M + 1))  );		
	}
}
