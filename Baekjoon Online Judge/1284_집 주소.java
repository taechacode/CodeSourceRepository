package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        while(!N.equals("0")) {
            int blank = N.length() - 1;
            int whiteSpace = 2;
            int numLength = 0;

            for(int i = 0; i < N.length(); i++) {
                if(N.charAt(i) == '1') {
                    numLength += 2;
                }
                else if(N.charAt(i) == '0') {
                    numLength += 4;
                }
                else {
                    numLength += 3;
                }
            }

            sb.append((whiteSpace + blank + numLength) + "\n");
            N = br.readLine();
        }

        System.out.print(sb);
    }
}