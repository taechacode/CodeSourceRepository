package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	static boolean[] isSelected;
	static int N, K, count;
	static int[] input, numbers;
	
	// 중복되는 조합의 경우를 없애기 위해 Set 사용
	static Set<String> set = new HashSet<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		input = new int[N];
		numbers = new int[K];
		isSelected = new boolean[100];
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		permutation(0);
		System.out.println(set.size());
	}
	
	public static void permutation(int cnt) { // cnt : 직전까지 뽑은 수의 개수

		// 기본 파트
		// 모든 수를 뽑았으면(K만큼) SET에 숫자를 넣고 재귀 종료
		if (cnt == K) {
			String result = "";
			for(int i = 0; i < numbers.length; i++) {
				result += numbers[i];
			}
			set.add(result);
			return;
		}

		// 입력받은 모든 수를 현재 자리에 넣어보기
		for (int i = 0; i < N; i++) {

			// 기존 자리의 수들과 중복되는지 체크
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i];
			isSelected[i] = true; // 현재 입력 받은 수를 사용 중임을 체크

			// 다음 수 뽑으러 가기
			permutation(cnt + 1);

			// 재귀가 끝나면 다시 방문 여부를 초기화
			// ex) 만약 처음에 0-1-2-... 이렇게 방문을 했다면
			// 그 다음 재귀에서는 1부터 시작하기 위해 1-0-2-3-...
			isSelected[i] = false;
		}
	}
}