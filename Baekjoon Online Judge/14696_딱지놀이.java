package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int testCase = 0; testCase < T; testCase++) {
        	String[] strA = br.readLine().split(" ");
        	String[] strB = br.readLine().split(" ");
        	
        	int[] scoreA = new int[5];
        	int[] scoreB = new int[5];
        	
        	for(int i = 1; i < strA.length; i++) {
        		scoreA[Integer.parseInt(strA[i])]++;
        	}
        	
        	for(int i = 1; i < strB.length; i++) {
        		scoreB[Integer.parseInt(strB[i])]++;
        	}
        	
        	if(scoreA[4] > scoreB[4]) {
        		sb.append("A").append("\n");
        	}
        	else if(scoreA[4] < scoreB[4]) {
        		sb.append("B").append("\n");
        	}
        	else if(scoreA[3] > scoreB[3]) {
        		sb.append("A").append("\n");
        	}
        	else if(scoreA[3] < scoreB[3]) {
        		sb.append("B").append("\n");
        	}
        	else if(scoreA[2] > scoreB[2]) {
        		sb.append("A").append("\n");
        	}
        	else if(scoreA[2] < scoreB[2]) {
        		sb.append("B").append("\n");
        	}
        	else if(scoreA[1] > scoreB[1]) {
        		sb.append("A").append("\n");
        	}
        	else if(scoreA[1] < scoreB[1]) {
        		sb.append("B").append("\n");
        	}
        	else {
        		sb.append("D").append("\n");
        	}
        }
        
        System.out.println(sb);
    }
}