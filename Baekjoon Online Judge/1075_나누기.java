package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		int temp = N / 100 * 100;
		
		int answer = temp % F;
		
		if(answer == 0) {
			System.out.println("00");
		}
		
		else {
			if((F - answer) < 10) {
				System.out.println("0" + (F - answer));
			}
			else {
				System.out.println(F - answer);
			}
		}
	}
}