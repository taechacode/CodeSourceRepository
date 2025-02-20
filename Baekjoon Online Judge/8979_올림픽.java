import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 0��° �׸� : ����, 1��° �׸� : �ݸ޴� ����, 2��° �׸� : ���޴� ����, 3��° �׸� : ���޴� ����, 4��° �׸� : ����
		int[][] nationBoard = new int[N][5]; 
		
		// LOOP: ������ �޴� ���� ����
		for(int nation = 0; nation < N ; nation++) {
			st = new StringTokenizer(br.readLine());			
			nationBoard[nation][0] = Integer.parseInt(st.nextToken());			
			nationBoard[nation][1] = Integer.parseInt(st.nextToken());
			nationBoard[nation][2] = Integer.parseInt(st.nextToken());
			nationBoard[nation][3] = Integer.parseInt(st.nextToken());			
		}
		
		// �ݸ޴� ������ �������� �������� ����
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
				
		int currentRank = 1; // ���� ����
		int answer      = 0; // ����
		
		// LOOP: ���� ����
		// 0��° ���� ������ ���� ������ �����ϵ�, ���� ������ ���޴�, ���޴� ������ �����ϸ� ���� ������ ������ ������ ����.
		for(int i = 0; i < N; i++) {
			nationBoard[i][4] = currentRank;
			
			if(i > 0) {
				currentRank += 1;
				// ���� �������� �ݸ޴� ������ ���� ���
				if(nationBoard[i][1] < nationBoard[i - 1][1]) {
					nationBoard[i][4] = currentRank;
				}
				// ���� ������ �ݸ޴� ������ ������ ���
				if(nationBoard[i][1] == nationBoard[i - 1][1]) {
					// ���� �������� ���޴� ������ ���� ���
					if(nationBoard[i][2] < nationBoard[i - 1][2]) {
						nationBoard[i][4] = currentRank;
					}
					// ���� ������ ���޴� ������ ������ ���
					if(nationBoard[i][2] == nationBoard[i - 1][2]) {
						// ���� �������� ���޴� ������ ���� ���
						if(nationBoard[i][3] < nationBoard[i - 1][3]) {
							nationBoard[i][4] = currentRank;
						}
						// ���� ������ ���޴� ������ ������ ���
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