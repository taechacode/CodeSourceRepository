import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());
		int d = Integer.valueOf(st.nextToken());
		int e = Integer.valueOf(st.nextToken());
		int f = Integer.valueOf(st.nextToken());
		
		int x = (c * e - b * f) / (a * e - b * d);
		int y = (a * f - c * d) / (a * e - b * d);

		
		System.out.println(x + " " + y);
	}
	
}