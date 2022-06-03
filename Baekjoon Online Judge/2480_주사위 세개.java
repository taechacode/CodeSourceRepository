package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] array = new int[7];
		
		for(int i = 0; i < 3; i++) {
			array[Integer.parseInt(st.nextToken())]++;
		}
		
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		
		for(int i = 6; i >= 1; i--) {
			if(array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		
		int answer = 0;
		switch(max) {
		case 1 :
			answer = maxIndex * 100;
			break;
		case 2 :
			answer = 1000 + maxIndex * 100;
			break;
		case 3 :
			answer = 10000 + maxIndex * 1000;
			break;
		}
		
		System.out.println(answer);
	}
}