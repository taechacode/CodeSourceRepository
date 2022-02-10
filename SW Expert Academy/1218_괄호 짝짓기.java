package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int result;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 1; i <= 10; i++) {
        	
        	// 얼마나 많은 괄호를 받을 것인지 지정
        	st = new StringTokenizer(br.readLine());
        	int testCase = Integer.parseInt(st.nextToken());
        	
        	// 입력한 testCase만큼 괄호 받아서 String형 str에 저장
        	st = new StringTokenizer(br.readLine());
        	String str = st.nextToken();
        	
        	// 스택 선언
        	Stack<Character> stk = new Stack<>();
        	
        	// 결과값의 기본값은 임의의 숫자 2로 설정
        	result = 2;
        	
        	for(int j = 0; j < str.length(); j++) {
        		
        		// 만약 여는 괄호가 j번째 입력일 경우 스택에 push
        		if(str.charAt(j) == '(' || str.charAt(j) == '[' || str.charAt(j) == '{' || str.charAt(j) == '<') {
        			stk.push(str.charAt(j));
        		}
        		
        		// 만약 여는 괄호와 짝이 맞는 닫는 괄호가 j번째 입력일 경우 여는 괄호를 스택에서 pop
        		else if (stk.peek() == '(' && str.charAt(j) == ')') {
        			stk.pop();
        		}
        		else if (stk.peek() == '[' && str.charAt(j) == ']') {
        			stk.pop();
        		}
        		else if (stk.peek() == '{' && str.charAt(j) == '}') {
        			stk.pop();
        		}
        		else if (stk.peek() == '<' && str.charAt(j) == '>') {
        			stk.pop();
        		}
        		
        		// 만약 짝이 맞지 않는 닫는 괄호가 오거나,
        		// 여는 괄호가 없는데 닫는 괄호가 오면 result를 유효하지 않음으로 지정
        		else {
        			result = 0;
        			break;
        		}
        	}
        	
        	// 스택이 정상적으로 모두 pop 되었고 result가 유효하지 않은 상태가 아니면
        	// result에 유효하다는 의미의 1 값을 저장함
        	if(stk.empty() && result != 0) {
        		result = 1;
        	}
        	else { // 그렇지 않을 경우 유효하지 않으므로 result에 1 저장
        		result = 0;
        	}
        	
        	// 결과 출력
        	System.out.println("#" + i + " " + result);
        }
    }
}
