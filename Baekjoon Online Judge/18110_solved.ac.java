
import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int N = Integer.parseInt(br.readLine());
		
		if(N == 0) {
			System.out.println(0);
			return;
		}
				
		int minEnd = (int) Math.round(N * 0.15) - 1;
		int maxStart = N - 1 - minEnd;
		
		int[] arr = new int[N];
		
		double sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		if(N == 1) {
			System.out.println(arr[0]);
			return;
		}
		
		Arrays.sort(arr);
		for(int i = minEnd + 1; i < maxStart; i++) {
			sum += arr[i];
		}
		
		System.out.println(Math.round(sum / (maxStart - minEnd - 1)));
				
	}
	
}
