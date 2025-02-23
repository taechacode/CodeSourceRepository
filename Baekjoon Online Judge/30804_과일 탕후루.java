import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		int[] fruitArray = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int inputFruitCnt = 0; inputFruitCnt < N; inputFruitCnt++) {
			fruitArray[inputFruitCnt] = Integer.parseInt(st.nextToken());
		}
		
		int[] fruitCntArray = new int[10]; // 과일 종류별 개수를 저장
		int maxFruitLen = 0; // 과일의 개수가 가장 많은 탕후루의 과일 개수 저장
		int left = 0;
		int distinct = 0; // 현재 슬라이딩 윈도우의 과일 종류 개수
		
		for(int right = 0; right < N; right++) {
			
			// 현재 탐색하는 오른쪽 포인터의 슬라이딩 윈도우 내 과일 개수가 0이라면			
			if(fruitCntArray[fruitArray[right]] == 0) {
				distinct++; // 과일 종류 개수를 증가
			}
			fruitCntArray[fruitArray[right]]++;
			
			// 현재 슬라이딩 윈도우 내 과일 종류 개수가 2개를 초과할 경우
			while(distinct > 2) {
				fruitCntArray[fruitArray[left]]--; // 현재 왼쪽 포인터 위치의 과일에 해당하는 개수를 1개 감소
				if(fruitCntArray[fruitArray[left]] == 0) { // 감소시킨 왼쪽 포인터의 슬라이딩 윈도우 내 과일 개수가 0이라면	
					distinct--; // 과일 종류 개수도 1개 감소
				}
				left++; // 왼쪽 포인터 오른쪽으로 이동
			}
			
			maxFruitLen = Math.max(maxFruitLen, right - left + 1);
		}
		
		System.out.println(maxFruitLen);
	}
	
}