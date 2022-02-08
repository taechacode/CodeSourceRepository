package SSAFY;

import java.util.*;
import java.io.*;

public class Solution {

	// 테스트 케이스 변수 선언
	static int testCase;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= testCase; i++) {
			int N = sc.nextInt();
			String[][] map = new String[N][N];
			for(int j = 0; j < N; j++) {
				String str = sc.next();
				map[j] = str.split("");
			}
			int sum = 0;
			
			for(int j = 0; j < N/2; j++) {
				for(int k = 0; k < j+1; k++) {
					sum += Integer.parseInt(map[j][N/2+k]);
					sum += Integer.parseInt(map[j][N/2-k]);
				}
				sum -= Integer.parseInt(map[j][N/2]);
			}
			
			for(int j = N/2; j < N; j++) {
				for(int k = 0; k < N-j; k++) {
					sum += Integer.parseInt(map[j][N/2+k]);
					sum += Integer.parseInt(map[j][N/2-k]);
				}
				sum -= Integer.parseInt(map[j][N/2]);
			}
			
			sb.append("#").append(i).append(" ").append(sum).append("\n");
			
		}
		System.out.println(sb);
	}
}
