import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		String N = br.readLine();
		
		long result = 0;
		long lineCount = 2;
		
		for(int i = 0; i < Integer.valueOf(N); i++) {
			lineCount = lineCount + (lineCount - 1);
			result = lineCount * lineCount;
		}
		
		System.out.println(result);
		
	}
	
}