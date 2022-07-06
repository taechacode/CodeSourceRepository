package Baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[26];
        
        int N = Integer.parseInt(br.readLine());
   
        for(int i = 0; i < N; i++) {
        	String str = br.readLine();
        	alphabet[str.charAt(0) - 97]++;
        }
        
        boolean isNull = true;
        for(int i = 0; i < 26; i++) {
        	if(alphabet[i] >= 5) {
        		sb.append((char)(i + 97));
        		isNull = false;
        	}
        }
        
        if(isNull) {
        	System.out.println("PREDAJA");
        }
        else {
        	System.out.println(sb.toString());
        }
        
    }
    
}