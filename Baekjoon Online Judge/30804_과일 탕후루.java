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
		
		int[] fruitCntArray = new int[10]; // ���� ������ ������ ����
		int maxFruitLen = 0; // ������ ������ ���� ���� ���ķ��� ���� ���� ����
		int left = 0;
		int distinct = 0; // ���� �����̵� �������� ���� ���� ����
		
		for(int right = 0; right < N; right++) {
			
			// ���� Ž���ϴ� ������ �������� �����̵� ������ �� ���� ������ 0�̶��			
			if(fruitCntArray[fruitArray[right]] == 0) {
				distinct++; // ���� ���� ������ ����
			}
			fruitCntArray[fruitArray[right]]++;
			
			// ���� �����̵� ������ �� ���� ���� ������ 2���� �ʰ��� ���
			while(distinct > 2) {
				fruitCntArray[fruitArray[left]]--; // ���� ���� ������ ��ġ�� ���Ͽ� �ش��ϴ� ������ 1�� ����
				if(fruitCntArray[fruitArray[left]] == 0) { // ���ҽ�Ų ���� �������� �����̵� ������ �� ���� ������ 0�̶��	
					distinct--; // ���� ���� ������ 1�� ����
				}
				left++; // ���� ������ ���������� �̵�
			}
			
			maxFruitLen = Math.max(maxFruitLen, right - left + 1);
		}
		
		System.out.println(maxFruitLen);
	}
	
}