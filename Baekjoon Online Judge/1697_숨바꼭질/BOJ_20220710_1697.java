package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] array = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

        System.out.println(array[K]);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int index = start;
        int searchPosition = 0;
        while(!queue.isEmpty()) {
            searchPosition = queue.poll();

            if(searchPosition == K) {
                return;
            }

            if(searchPosition - 1 >= 0 && array[searchPosition - 1] == 0) {
                array[searchPosition - 1] = array[searchPosition] + 1;
                queue.add(searchPosition - 1);
            }

            if(searchPosition + 1 <= array.length - 1 && array[searchPosition + 1] == 0) {
                array[searchPosition + 1] = array[searchPosition] + 1;
                queue.add(searchPosition + 1);
            }

            if(searchPosition * 2 <= array.length - 1 && array[searchPosition * 2] == 0) {
                array[searchPosition * 2] = array[searchPosition] + 1;
                queue.add(searchPosition * 2);
            }
        }

    }

}