package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<>();
			int sum = 0;
			while(st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp % 2 == 1) {
					continue;
				}
				sum += temp;
				list.add(temp);
			}
			
			Collections.sort(list);
			
			System.out.print(sum + " " + list.get(0) + "\n");
		}
	}
}