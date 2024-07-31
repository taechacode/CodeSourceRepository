class Solution {
    public String solution(int n, int t, int m, int p) {
		// n : 진법
		// t : 미리 구할 숫자의 개수
		// m : 게임에 참가하는 인원
		// p : 튜브의 순서
		
		String answer = "";
		
		int currentOrder = 0; // 참여자 순서 (전체)
		
		// 1. 최대 t * m 까지 숫자까지 게임을 진행하므로 반복.
		for(int num = 0; num < t * m; num++) {		
			
			// 2. 현재 숫자를 게임에서 정한 진법대로 변환 (대문자 변환 포함)
			String currentNum = Integer.toString(num, n).toUpperCase();
			
			// 3. 숫자가 2자리 이상일 경우 문자 1자씩 확인
			for(int currentNumPos = 0; currentNumPos < currentNum.length(); currentNumPos++) {
				
				// 3-1. 참여자 순서 증가
				currentOrder++;
				
				// 3-2. 현재 참여자 순서가 튜브 차례이면 정답에 추가
				if(currentOrder == p) {
					answer += currentNum.substring(currentNumPos, currentNumPos + 1);
				}
				
				// 3-3. 참여자 순서가 1바퀴를 다 돌았으면 순서 초기화
				if(currentOrder == m) currentOrder = 0;		
				
				// 3-4. 튜브가 필요한 숫자를 모두 정답에 추가했으면 반복문 종료
				if(answer.length() >= t) break;
			}
			
			// 4. 튜브가 필요한 숫자를 모두 정답에 추가했으면 반복문 종료
			if(answer.length() >= t) break;			
		}
		
		return answer;
    }
}