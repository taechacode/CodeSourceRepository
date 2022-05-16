package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static int[] sum = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int score = 0;
		int min = Integer.MAX_VALUE;
		int min_index = 0;
		for(int i = 0; i < 10; i++) {
			score += Integer.parseInt(br.readLine());
			sum[i] = score;
			if(min >= Math.abs(100 - score)) {
				min = Math.abs(100 - score);
				min_index = i;
			}
		}
		
		System.out.println(sum[min_index]);
	}
}