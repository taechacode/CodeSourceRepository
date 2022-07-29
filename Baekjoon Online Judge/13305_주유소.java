package Baekjoon;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		BigInteger[] roadLength = new BigInteger[N - 1];
		BigInteger[] oilPrice = new BigInteger[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N - 1; i++) {
			roadLength[i] = new BigInteger(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			oilPrice[i] = new BigInteger(st.nextToken());
		}
		
		BigInteger answer = oilPrice[0].multiply(roadLength[0]);
		BigInteger minPrice = oilPrice[0];
		
		for(int i = 1; i < N - 1; i++) {
			if(oilPrice[i].compareTo(minPrice) < 0) {
				answer = answer.add(oilPrice[i].multiply(roadLength[i]));
				minPrice = oilPrice[i];
			} else {
				answer = answer.add(minPrice.multiply(roadLength[i]));
			}			
		}
		
		System.out.println(answer);
	}
			
}
