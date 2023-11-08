
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine())/4;
		
		for(int i = 0; i < N; i++) {
			sb.append("long ");
		}
		
		sb.append("int");
		
		System.out.println(sb.toString());
		
	}

}
