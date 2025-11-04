import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String ISBN = br.readLine();
		
		int ISBNSum = 0, ISBNCheck = 0;
		
		for(int i = 0; i < ISBN.length(); i++) {
			if(ISBN.charAt(i) != '*') {
				if(i % 2 == 0) {
					ISBNSum += ISBN.charAt(i) - '0';
				} else {
					ISBNSum += (ISBN.charAt(i) - '0') * 3;
				}
			} else {
				ISBNCheck = i;
			}			
		}
		
		int answer = 0;
		
		while(true) {
			if(ISBNCheck % 2 == 0) {
				if((ISBNSum + answer) % 10 == 0) {
					System.out.println(answer);
					break;
				}
			} else {
				if((ISBNSum + answer * 3) % 10 == 0) {
					System.out.println(answer);
					break;
				}
			}
			
			answer++;
		}
		
	}
}
