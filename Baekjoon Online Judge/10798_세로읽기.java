
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		String str1, str2, str3, str4, str5;
		
		str1 = br.readLine();
		str2 = br.readLine();
		str3 = br.readLine();
		str4 = br.readLine();
		str5 = br.readLine();
		
		for(int i = 1; i <= 15; i++) {
			if(str1.length() >= i) {
				sb.append(str1.charAt(i - 1));
			}
			if(str2.length() >= i) {
				sb.append(str2.charAt(i - 1));
			}
			if(str3.length() >= i) {
				sb.append(str3.charAt(i - 1));
			}
			if(str4.length() >= i) {
				sb.append(str4.charAt(i - 1));
			}
			if(str5.length() >= i) {
				sb.append(str5.charAt(i - 1));
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
}
