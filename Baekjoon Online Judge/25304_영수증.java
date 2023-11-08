
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int a;
		int b;
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sum += a * b;
		}
		
		if(X == sum) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}

}
