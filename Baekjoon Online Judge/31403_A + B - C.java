import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {

		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();

		System.out.println(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C));
		System.out.println(Integer.parseInt(A + B) - Integer.parseInt(C));
	}
	
}