package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static boolean[][] visited;
    static int V, H, cheese, count, time;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        array = new int[V][H];

        for(int row = 0; row < V; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < H; col++) {
                array[row][col] = Integer.parseInt(st.nextToken());
                if(array[row][col] == 1) {
                    cheese++;
                }
            }
        }

        count = 0;

        while(cheese != 0) {
            time++;
            count = cheese;
            bfs();
        }

        System.out.println(time);
        System.out.println(count);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {0, 0});
        visited = new boolean[V][H];
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= V || ny >= H || visited[nx][ny]) {
                    continue;
                }

                if(array[nx][ny] == 1) {
                    cheese--;
                    array[nx][ny] = 0;
                } else {
                    queue.offer(new int[] {nx, ny});
                }

                visited[nx][ny] = true;
            }

        }

    }

}