import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String answer = "";
		
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long temp = N;
				
		while(temp >= B) {						
			addAnswer(temp % B);
			temp = temp / B;
		}
		
		addAnswer(temp % B);
		System.out.print(answer);
	}
	
	private static void addAnswer(long input) {
		if(input >= 10) {
			answer = (char)(input + 55) + answer;
		} else {
			answer = input + answer;
		}
	}
	
}