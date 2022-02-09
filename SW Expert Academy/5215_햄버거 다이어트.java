package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int T, N, L, result;
    static int[] score;
    static int[] kal;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= T; i++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken()); // 재료의 수
        	L = Integer.parseInt(st.nextToken()); // 칼로리 제한
        	score = new int[N];
        	kal = new int[N];
        	
        	// 재료에 관한 점수와 칼로리 제한 정보 담기
        	for(int j = 0; j < N; j++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		score[j] = Integer.parseInt(st.nextToken());
        		kal[j] = Integer.parseInt(st.nextToken());
        	}
        	
        	result = 0;
        	hamburgerDiet(0, 0, 0);
        	
        	System.out.println("#" + i + " " + result);
        }
    }
    
    static void hamburgerDiet(int cnt, int sco, int kcal) {
    	
    	// 칼로리 제한을 초과한 경우
    	if(kcal > L) { 
    		return;
    	}
    	
    	// 칼로리 제한을 초과하지 않은 경우
    	if (kcal <= L) {
    		result = Math.max(result, sco);
    	}
    	
    	// 모든 조합의 확인이 끝났을 경우
    	if(cnt == N) return;
    	
    	hamburgerDiet(cnt + 1, sco + score[cnt], kcal + kal[cnt]);
    	hamburgerDiet(cnt + 1, sco, kcal);
    }
}
