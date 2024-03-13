
import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pq.add(Long.valueOf(br.readLine()));
		}
		
		long sum = 0;
		
		while(pq.size() > 1) {
			long temp1 = pq.poll();
			long temp2 = pq.poll();
			sum += temp1 + temp2;
			pq.add(temp1 + temp2);
		}

		System.out.println(sum);
	}
	
}
