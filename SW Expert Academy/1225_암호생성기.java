package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int testCase = 1; testCase <= 10; testCase++) {
			int count = 1;
			int t = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			while (true) {
				
				// Queue의 가장 front에 있는 수를 num에 대입
				int num = queue.poll();
				
				// num에서 현재 사이클을 뺄 때 0보다 작거나 같으면
				// 더이상 숫자를 변경하지 않고 0으로 Queue의 rear에 삽입
				if (num - count <= 0) {
					queue.offer(0);
					break;
				}
				
				// num에서 현재 사이클을 뺀 값이 0보다 크면
				// Queue의 rear에 값을 삽입
				queue.offer(num - count);
				
				// 한 사이클이 5까지이기에 사이클을 다 돌고나면
				// 다시 사이클을 0으로 초기화
				if (count == 5) {
					count = 0;
				}
				
				// 다음 사이클을 위해 count를 증가
				count++;
			}
			
			sb.append("#").append(t).append(" ");
			
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			
			sb.append("\n");
		}
        
		System.out.print(sb);
    }
}
