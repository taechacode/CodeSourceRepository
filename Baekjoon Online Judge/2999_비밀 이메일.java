package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static int[] sum = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int r = Integer.MIN_VALUE;
		for(int i = 1; i <= str.length(); i++) {
			if(str.length() % i == 0) {
				if(i <= str.length() / i) {
					r = Math.max(r, i);
				}
			}
		}
		int c = str.length() / r;
		
		char[][] array = new char[c][r];
		
		int index = 0;
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				array[i][j] = str.charAt(index++);
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(array[j][i]);
			}
		}
		
	}
}