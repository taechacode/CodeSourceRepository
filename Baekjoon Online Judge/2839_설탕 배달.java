package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int count;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		while(n > 0) {
			
			// 만약 5로 나누어진다면 5kg으로만 설탕 배달하는 것이 최선이다.
			if(n % 5 == 0) {
				n = n - 5;
				count++;
			}
			
			// 그렇지 않다면 3kg으로 구성하여 설탕을 배달한다.
			else {
				n = n  - 3;
				count++;
			}
		}
		
		// 만약 남은 설탕이 0일 경우 정확하게 n 킬로그램을 배달할 수 있으므로 
		// 설탕 봉지의 개수를 담은 변수인 count를 출력한다.
		if(n == 0) {
			System.out.println(count);
		}
		
		// 그게 아니라면 -1을 출력한다.
		else {
			System.out.println(-1);
		}
	}
}
