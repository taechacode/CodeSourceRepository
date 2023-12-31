
import java.io.*;
import java.util.*;

class Number {
	long num;
	int depth;
	Number(long num, int depth) {
		this.num = num;
		this.depth = depth;
	}
}

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static long A, B;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		Number answer = BFS();
		
		System.out.println(answer.depth);		
	}
	
	private static Number BFS() {
		
		Queue<Number> queue = new LinkedList<>();		
		queue.add(new Number(A, 1));
		
		while(!queue.isEmpty()) {
			Number current = queue.poll();
			
			if(current.num == B) {
				return current;
			}
			
			if(current.num > B) {
				continue;
			}
				
			queue.add(new Number(multiplyTwo(current.num), current.depth + 1));
			queue.add(new Number(insertOne(current.num), current.depth + 1));
		}
		
		return new Number(-1, -1);
	}
	
	private static long multiplyTwo(long n) {		
		return n * 2;
	}
	
	private static long insertOne(long n) {		
		return Long.parseLong(String.valueOf(n) + "1");
	}
	
}
