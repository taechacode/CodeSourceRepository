package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Set<Integer> setSang = new HashSet<Integer>();		
		for(int i = 0; i < N; i++) {
			setSang.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			if(setSang.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}		
}
