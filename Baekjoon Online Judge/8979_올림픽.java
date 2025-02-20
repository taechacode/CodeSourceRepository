import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 0번째 항목 : 국가, 1번째 항목 : 금메달 개수, 2번째 항목 : 은메달 개수, 3번째 항목 : 동메달 개수, 4번째 항목 : 순위
		int[][] nationBoard = new int[N][5]; 
		
		// LOOP: 국가와 메달 정보 저장
		for(int nation = 0; nation < N ; nation++) {
			st = new StringTokenizer(br.readLine());			
			nationBoard[nation][0] = Integer.parseInt(st.nextToken());			
			nationBoard[nation][1] = Integer.parseInt(st.nextToken());
			nationBoard[nation][2] = Integer.parseInt(st.nextToken());
			nationBoard[nation][3] = Integer.parseInt(st.nextToken());			
		}
		
		// 금메달 개수를 기준으로 내림차순 정렬
		Arrays.sort(nationBoard, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					if(o1[2] == o2[2]) {
						return o2[3] - o1[3];
					} else {
						return o2[2] - o1[2];
					}
				} else {
					return o2[1] - o1[1];
				}
			}
			
		});
				
		int currentRank = 1; // 현재 순위
		int answer      = 0; // 정답
		
		// LOOP: 순위 저장
		// 0번째 이후 순위는 현재 순위는 갱신하되, 이전 국가와 은메달, 동메달 점수가 동일하면 이전 국가와 동일한 순위로 적용.
		for(int i = 0; i < N; i++) {
			nationBoard[i][4] = currentRank;
			
			if(i > 0) {
				currentRank += 1;
				// 이전 국가보다 금메달 개수가 적을 경우
				if(nationBoard[i][1] < nationBoard[i - 1][1]) {
					nationBoard[i][4] = currentRank;
				}
				// 이전 국가와 금메달 개수가 동일할 경우
				if(nationBoard[i][1] == nationBoard[i - 1][1]) {
					// 이전 국가보다 은메달 개수가 적을 경우
					if(nationBoard[i][2] < nationBoard[i - 1][2]) {
						nationBoard[i][4] = currentRank;
					}
					// 이전 국가와 은메달 개수가 동일할 경우
					if(nationBoard[i][2] == nationBoard[i - 1][2]) {
						// 이전 국가보다 동메달 개수가 적을 경우
						if(nationBoard[i][3] < nationBoard[i - 1][3]) {
							nationBoard[i][4] = currentRank;
						}
						// 이전 국가와 동메달 개수가 동일할 경우
						if(nationBoard[i][3] == nationBoard[i - 1][3]) {
							nationBoard[i][4] = nationBoard[i - 1][4];
						}
					}					
				}
			}
			
			if(nationBoard[i][0] == K) {
				answer = nationBoard[i][4];
				break;
			}
		}
		
		System.out.println(answer);
		
	}
	
}