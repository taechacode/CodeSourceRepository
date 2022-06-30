package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		for(int i = 1; i <= 8; i++) {
			
			String[] str = br.readLine().split("");
			
			if(i % 2 == 1) {
				for(int j = 1; j <= 8; j += 2) {
					if(str[j - 1].equals("F")) {
						count++;
					}
				}
			}
			
			if(i % 2 == 0) {
				for(int j = 2; j <= 8; j += 2) {
					if(str[j - 1].equals("F")) {
						count++;
					}
				}
			}
			
 		}
		
		System.out.println(count);
	}
}