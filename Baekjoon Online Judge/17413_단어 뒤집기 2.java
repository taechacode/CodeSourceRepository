package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Stack<Character> stk1 = new Stack<>();
		
		// 문자열을 거꾸로 stk1에 집어넣음
		for(int i = str.length() - 1; i >= 0; i--) {
			stk1.push(str.charAt(i));
		}
		
		Stack<Character> stk2 = new Stack<>();
		
		// 입력한 문자열을 모두 읽을 때까지 반복
		while(!stk1.isEmpty()) {
			
			// 만약 탐색하는 문자가 여는 괄호 '<'일 경우
			if(stk1.peek() == '<') {
				
				// 이전에 탐색하고 있었던 괄호 밖 문자열이 있었다면 모두 StringBuilder에 추가
				while(!stk2.isEmpty()) {
					sb.append(stk2.pop());
				}
				
				// 닫는 괄호 '>'가 나타나기 전까지 모든 문자를 StringBuilder에 추가
				while(stk1.peek() != '>') {
					sb.append(stk1.pop());
				}
				
				// 마지막 닫는 괄호 '>'까지 StringBuilder에 추가
				sb.append(stk1.pop());
			}
			
			else {
				
				// 만약 탐색 문자가 공백이 아닐 경우
				if(stk1.peek() != ' ') {
					
					// 역정렬하기 위해 stk2에 공백이나 괄호가 나오기 전까지 push
					stk2.push(stk1.pop());
				}
				
				// 만약 공백을 만나버렸을 경우
				else if(stk1.peek() == ' ') {
					
					// 기존에 stk2에 담아놓았던 문자들을 pop()하면서 StringBuilder에 추가
					while(!stk2.isEmpty()) {
						sb.append(stk2.pop());
					}
					sb.append(stk1.pop());
				}
			}
			
		}
		
		// 만약 stk2에 남아있던 문자가 있다면 StringBuilder에 추가
		if(!stk2.isEmpty()) {
			while(!stk2.isEmpty()) {
				sb.append(stk2.pop());
			}
		}
		
		System.out.println(sb);
	}
}