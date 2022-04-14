package Baekjoon;

import java.util.*;
import java.io.*;

public class Main {
	 
    static int[][] taste;
    static boolean[] visited;
    static int n, min;
 
    private static void subset(int index, int sour, int bitter) {
    	
        if (index == n) {
            if (min > Math.abs(sour - bitter) && bitter != 0) {
                min = Math.abs(sour - bitter);
            }
            return;
        }
        
        // 이미 사용한 재료일 경우 다음 재료를 사용
        visited[index] = true;
        subset(index + 1, sour * taste[0][index], bitter + taste[1][index]);
        
        // 이미 사용하지 않은 재료일 경우 해당 재료를 사용
        visited[index] = false;
        subset(index + 1, sour, bitter);
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        taste = new int[2][n];
        visited = new boolean[n];
        min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 0에는 신 맛, 1에는 쓴 맛을 담는다.
            taste[0][i] = Integer.parseInt(st.nextToken());
            taste[1][i] = Integer.parseInt(st.nextToken());
        }
        
        subset(0, 1, 0);
        System.out.println(min);
    }
}
