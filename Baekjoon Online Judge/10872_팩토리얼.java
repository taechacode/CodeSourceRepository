package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static int answer = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		factorial(n);
		System.out.println(answer);
	}
	
	private static void factorial(int n) {
		if(n == 0) {
			return;
		}
		answer *= n;
		factorial(--n);
	}
}