package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static String X, Y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = br.readLine();
		recursion(X, 0);
		
		if(Integer.parseInt(Y) % 3 == 0) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	public static void recursion(String input, int cnt) {
		if(input.length() == 1) {
			Y = input;
			System.out.println(cnt);
			return;
		}
		
		int sum = 0;
		for(int i = 0; i < input.length(); i++) {
			sum += input.charAt(i) - '0';
		}

		recursion(String.valueOf(sum), cnt + 1);
	}
}