import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		while(true) {
			
			int n = Integer.parseInt(br.readLine());
			if(n == -1) break;
			
			int sum = 1;
			StringBuffer sb = new StringBuffer();
			sb.append(n + " = 1");
			
			for(int f = 2; f < n; f++) { // loop factors
				
				if(n % f == 0) {
					sum += f;
					sb.append(" + " + f);
				}
				
			}
			
			if(sum == n) {
				System.out.println(sb.toString());
			} else {
				System.out.println(n + " is NOT perfect.");
			}
		}		
		
	}
	
}