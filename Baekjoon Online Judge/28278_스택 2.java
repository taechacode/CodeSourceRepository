
import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		
		int order = 0;
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			order = Integer.parseInt(st.nextToken());
			
			if(order == 1) {
				stk.push(Integer.parseInt(st.nextToken()));	
			} else if(order == 2) {
				if(!stk.isEmpty()) {
					sb.append(stk.pop()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else if(order == 3) {
				sb.append(stk.size()).append("\n");
			} else if(order == 4) {
				if(!stk.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}
			} else if(order == 5) {
				if(!stk.isEmpty()) {
					sb.append(stk.peek()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}
			
		}
		
		System.out.println(sb.toString());
	}
	
}
