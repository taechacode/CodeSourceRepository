
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		char number;
		int multi = 0;
		int answer = 0;
		
		for(int pos = N.length() - 1; pos >= 0; pos--) {
			
			number = N.charAt(pos);
			
			// 대문자 알파벳은 아스키 코드가 65부터 시작 90으로 끝남
			// 숫자는 아스키 코드가 48부터 시작 57로 끝남
			// 58를 차감해도 0보다 크다면 해당 number 변수는 대문자 알파벳일 것이다.
			if(number - 58 > 0) {
				answer += (number - 55) * Math.pow(B, multi);
			} else {
				answer += (number - 48) * Math.pow(B, multi);
			}
			
			multi++;
		}
		
		System.out.println(answer);
		
	}
	
}
