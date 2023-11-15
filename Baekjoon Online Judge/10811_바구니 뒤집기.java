
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static int[] arr = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int basketNumber = 0; basketNumber < arr.length; basketNumber++) {
			arr[basketNumber] = basketNumber + 1;
		}
		
		int i, j;
		
		for(int reverseCount = 0; reverseCount < M; reverseCount++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			reverseSwitch(i, j);
		}
		
		for(int pos = 0; pos < arr.length; pos++) {
			sb.append(arr[pos]).append(" ");
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	private static void reverseSwitch(int i, int j) {
		
		if(j - i <= 0) {
			return;
		}
		
		int start = i - 1;
		int end = j - 1;
		int temp;
		
		while(end - start > 0) {
			
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
			
		}
		
	}

}
