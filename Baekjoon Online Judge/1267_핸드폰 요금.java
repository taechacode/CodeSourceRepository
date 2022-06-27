package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int Y = 0;
		int M = 0;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			Y += (num / 30 + 1) * 10;
			M += (num / 60 + 1) * 15;
		}
		
		if(Y < M) {
			System.out.println("Y " + Y);
		}
		
		else if(Y > M) {
			System.out.println("M " + M);
		}
		
		else {
			System.out.println("Y M " + Y);
		}
	}
}