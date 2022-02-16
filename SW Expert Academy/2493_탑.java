package Baekjoon;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		Stack<int[]> stk = new Stack<>(); //Stack에 int형 배열 저장
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!stk.isEmpty()) {
				
				// 가장 앞의 탑이 n보다 작으면,
				// 앞으로 어떠한 신호도 수신할 수 없으므로 스택에서 제거해버린다.
				// (가지고 있을 필요가 없음)
				if(stk.peek()[0] < n) 
					stk.pop();
				
				// n보다 크다면, 해당 탑의 번호를 출력
				else { 
					System.out.print(stk.peek()[1] + " ");
					break;
				}
			}
			
			//탑이 비었다면 0을 출력
			if(stk.empty()) 
				System.out.print("0 ");
			
			//탑의 높이(n)와 탑의 번호(i+1) 배열을 저장
			stk.push(new int[] {n, i+1}); 
		}
			
	}
}