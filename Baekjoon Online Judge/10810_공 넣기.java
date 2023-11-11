
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[N];
		int i, j, k;
		
		for(int input = 0; input < M; input++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			for(int insert = i - 1; insert <= j - 1; insert++) {
				basket[insert] = k;
			}
		}
		
		for(int col = 0; col < basket.length; col++) {
			sb.append(basket[col]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}

}
