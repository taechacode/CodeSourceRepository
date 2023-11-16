
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static int[] arr = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		int pos = Integer.parseInt(br.readLine());
		
		System.out.println(str[pos - 1]);
		
	}
	
}
