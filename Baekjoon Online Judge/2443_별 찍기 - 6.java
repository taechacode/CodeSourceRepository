package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int r = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= 2 * N - r; j++) {
				System.out.print("*");
			}
			r += 2;
			System.out.println();
		}
	}
}