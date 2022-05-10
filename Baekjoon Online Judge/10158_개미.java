package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Java 8 버전으로 실행했을 때만 시간 초과가 나지 않습니다 (BAEKJOON)
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
                
        st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        int time = Integer.parseInt(br.readLine());
        
        // p와 q의 로테이션을 따로 두고 계산
        // p 지점에서 time만큼 더 이동했을 때 p 좌표가 어디있을 지 계산
        int ans_p = (p + time) % (2 * w);
        
        // 로테이션 범위가 2 * w로 계산했기 때문에
        // w보다 작으면 해당 값이 정답이지만,
        // 만약 w보다 크다면 w에서 해당 값을 빼준 값이 정답
        ans_p = w - Math.abs(w - ans_p);
        
    	// q 지점에서 time만큼 더 이동했을 때 q 좌표가 어디있을 지 계산
        int ans_q = (q + time) % (2 * h);
        
        // 로테이션 범위가 2 * h로 계산했기 때문에
        // w보다 작으면 해당 값이 정답이지만,
        // 만약 h보다 크다면 h에서 해당 값을 빼준 값이 정답
        ans_q = h - Math.abs(h - ans_q);
        
        System.out.println(ans_p + " " + ans_q);
    }
}