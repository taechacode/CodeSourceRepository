package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		System.out.println(factorial(n));
	}
	
	private static int factorial(int n) {
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		return factorial(n - 2) + factorial(n - 1);
	}
}