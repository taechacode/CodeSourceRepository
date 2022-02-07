package SSAFY;

import java.util.Scanner;

public class Solution {
     
    static int testCase, H, W, x, y, d;
    static char[][] map;
    static int[][] dir = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}}; // 동서남북
    
    // 해당 좌표가 맵 범위 안인지 판별하는 isInside 메소드    
    public static boolean isInside(int x, int y) {
        return x>=0 && x<H && y>=0 && y<W; 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 반복 횟수 testCase 입력
        testCase = sc.nextInt();
         
        for(int i=1; i<=testCase; i++) {
            H = sc.nextInt();
            W = sc.nextInt();
             
            map = new char[H][W];
             
            x = 0;
            y = 0;
            d = 0; // 1: 동, 2: 서, 3: 남, 4: 북
             
            for(int j = 0; j < H; j++) {
                String st = sc.next();
                for(int k = 0; k < W; k++) {
                    map[j][k] = st.charAt(k);
                     
                    // 탱크 문자열을 확인하면 탱크가 바라보고 있는 방향과 좌표를 저장
                    if(map[j][k] == '^' || map[j][k] == 'v' || map[j][k] == '<' || map[j][k] == '>') {
                        if(map[j][k] == '^') d = 4;
                        else if(map[j][k] == 'v') d = 3;
                        else if(map[j][k] == '<') d = 2;
                        else if(map[j][k] == '>') d = 1;
                         
                        x = j;
                        y = k;
                    }
                }
            }
            
            // 명령문의 길이 입력
            int N = sc.nextInt();
            
            // 명령문 입력
            String str = sc.next();
             
            for(int j = 0; j < N; i++) {
                char cur = str.charAt(j);
                int nx, ny;
                
                // 만약 명령문에서 U, D, L, R과 같은 탱크 이동 명령어가 발견되면
                if(cur == 'U' || cur == 'D' || cur == 'L' || cur =='R') {
                    // 해당 탱크 이동 명령어에 맞게끔 탱크 방향 전환
                	if(cur == 'U') {
                        d = 4;
                        map[x][y] = '^';
                    }
                    
                    else if(cur == 'D') {
                        d = 3;
                        map[x][y] = 'v';
                    }
                    
                    else if(cur == 'L') {
                        d = 2;
                        map[x][y] = '<';
                    }
                    
                    else if(cur == 'R') {
                        d = 1;
                        map[x][y] = '>';
                    }
                    
                	// 이동하고자 하는 좌표가 맵의 범위 안이고 평지이면 탱크를 이동
                    nx = x + dir[d][0];
                    ny = y + dir[d][1];
                    
                    if(isInside(nx, ny)) {
                        if(map[nx][ny] == '.') {
                            map[nx][ny] = map[x][y];
                            map[x][y] = '.';
                            x = nx; y = ny;
                        }
                    }
                }
                
                // 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
                else if(cur == 'S') {
                    nx = x;
                    ny = y;
                     
                    while(true) {
                    	// 현재 바라보고 있는 좌표로 방향 좌표를 반복회차마다 더하면
                    	// 좌표가 바라보는 방향으로 한 칸씩 이동하면서 탐색하게 됨
                        nx += dir[d][0];
                        ny += dir[d][1];
                        
                        // 포탄이 맵 범위를 벗어나거나 강철벽을 만나면 break
                        if(!isInside(nx, ny) || map[nx][ny] == '#')
                        	break;
                        
                        // 만약 벽돌을 만난다면 평지로 바꿔버리고 break
                        else if(map[nx][ny] == '*') {
                            map[nx][ny] = '.';
                            break;
                        }
                    }
                }
            }
            
            // 결과 출력
            System.out.print("#" + i + " ");
            
            for(int j = 0; j < H; j++) {
                for(int k = 0; k < W; k++) {
                    System.out.print(map[j][k]);
                }
                System.out.println();
            }
            
        }
    }
}
