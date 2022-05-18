package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 롤케이크의 길이를 나타내는 L
		int L = Integer.parseInt(br.readLine());
		
		// 조각 케이크별로 원하는 방청객의 번호를 넣는 배열
		int[] array = new int[L + 1];
		
		// 방청객의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 가장 많이 조각 수가 될 것으로 기대되는 expectMax
		int expectMax = Integer.MIN_VALUE;
		
		// expectMax만큼 조각 수를 가지는 방청객의 번호
		int expectMaxIndex = 0;
		
		// 방청객이 종이에 원하는 조각 케이크를 써서 냄
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			for(int j = P; j <= K; j++) {
				
				// 만약 해당 조각 케이크를 아무도 고르지 않았다면 선택 가능
				if(array[j] == 0) {
					array[j] = i;
				}
			}
			
			// 기존 expectMax보다 현재 탐색 중인 방청객 번호의 조각 케이크가 많으면 갱신
			if(expectMax < K - P + 1) {
				expectMax = K - P + 1;
				expectMaxIndex = i;
			}
		}
		
		System.out.println(expectMaxIndex);
		
		// 실제 배열에 담긴 방청객들에게 할당될 조각 케이크의 수를 담는 countArray 배열
		int[] countArray = new int[N + 1];
		
		// 실제로 가장 많은 조각 케이크가 할당된 방청객의 번호를 가지는 realMaxIndex
		int realMaxIndex = 0;
		for(int i = 1; i <= N; i++) {
			
			// 전체 롤 케이크를 한 바퀴 돌면서 i 번호를 가지고 있는 조각 케이크 수를 계산
			for(int j = 1; j <= L; j++) {
				if(array[j] == i) {
					countArray[i]++;
				}
			}
			
			// 만약 현재 탐색 중인 i 번호 방청객이 기존 realMaxIndex 번호 방청객보다
			// 할당된 조각 케이크 수가 많다면 갱신
			if(countArray[realMaxIndex] < countArray[i]) {
				realMaxIndex = i;
			}
		}
		
		System.out.println(realMaxIndex);
	}
}