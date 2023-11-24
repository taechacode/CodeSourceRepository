
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		
		int left = 0;
		int right = str.length() - 1;
		
		boolean palindrome = true;
		
		while(left <= right) {
			
			if(str.charAt(left) != str.charAt(right)) {
				palindrome = false;
			}
			
			if(!palindrome) break;
			
			left++;
			right--;
			
		}
		
		System.out.println(palindrome ? 1 : 0);
		
	}
	
}
