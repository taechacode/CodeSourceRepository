
import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
			
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
				
		int number = 0;
		int[] numberArray = new int[10];
		long total = 0;
		
		for(int i = 0; i < str.length(); i++) {
			number = Integer.parseInt(str.substring(i, i + 1));
			numberArray[number]++;
			total += number;
		}
		
		if(!str.contains("0") || total % 3 != 0) {
			System.out.println("-1");
			return;
		}
		
		for(int i = 9; i >= 0; i--) {
			while(numberArray[i] > 0) {
				sb.append(i);
				numberArray[i]--;
			}			
		}
		
		System.out.println(sb.toString());
		
	}
			
}
