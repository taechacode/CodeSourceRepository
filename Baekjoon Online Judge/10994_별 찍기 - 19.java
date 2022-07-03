package Baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = N * 4 - 3;
        char[][] map_result = drawmap(N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                sb.append(map_result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static char[][] drawmap(int N) {
        int size = N * 4 - 3;
        char[][] map = new char[size][size];

        for(int i = 0; i < size; i++) { // 맵을 빈 칸으로 초기화
            Arrays.fill(map[i], ' ');
        }

        if(size == 1) { // 만약 크기가 1인 맵이라면 별 1개 채우고 끝내기
            map[0][0] = '*';
            return map;
        }

        char[][] map_pre = drawmap(N - 1); // 이전 맵 가져오기
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i == 0 || j == 0 || i == size - 1 || j == size - 1) { // 현재 맵의 테두리는 전부 별로 채우기
                    map[i][j] = '*';
                }
                else if(i >= 2 && j >= 2 && i <= size - 3 && j <= size - 3) { // (2, 2)부터는 이전 맵을 그리기
                    map[i][j] = map_pre[i - 2][j - 2]; // 현재 좌표를 이전 맵의 좌표로 계산하여 대입
                }
            }
        }

       return map;
    }
    
}