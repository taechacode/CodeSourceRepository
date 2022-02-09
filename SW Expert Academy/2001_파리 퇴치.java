package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= testCase; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	// 배열 크기 설정 후 맵핑
        	int[][] array = new int[N][N];
        	for(int j = 0; j < N; j++) {
        		st = new StringTokenizer(br.readLine());
        		for(int k = 0; k < N; k++) {
        			array[j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	// System.out.println(Arrays.deepToString(array));
        	
        	int max = 0;
        	int sum = 0;
        	
        	// 배열 전체를 순회
        	for(int x = 0; x < N; ++x) {
        		for(int y = 0; y < N; ++y) {
        			
        			// 배열 전체를 순회하면서 M 크기의 범위 안에 있는
        			// 모든 숫자를 sum에 더하기
        			sum = 0;
        			if(x + M <= N && y + M <= N ) {
        				for(int j = x; j < x + M; ++j) {
                    		for(int k = y; k < y + M; ++k) {
            
                    			sum += array[j][k];
                    			
                    		}
                    	}
        			}
        			
        			// 현재 범위의 합인 sum이 최대값 max보다 크면 max 값 교체
        			if(max < sum) {
        				max = sum;
        			}
        			
        		}
        	}
        	
        	// 테스트케이스 회차와 최대값 출력
        	System.out.print("#" + i + " " + max + "\n");
        }
    }
}
