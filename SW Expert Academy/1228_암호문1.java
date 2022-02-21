package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트케이스 10번 반복
        for(int testCase = 1; testCase <= 10; testCase++) {
        	
        	LinkedList<Integer> list = new LinkedList<Integer>();
        	
        	// 암호문 원문 숫자를 몇 개나 받을지 지정
        	int original_num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < original_num; i++) {
            	list.add(Integer.parseInt(st.nextToken()));
            }
            
            // 새로 추가할 숫자들을 몇 개나 받을지 지정
            int add_num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int i = 0; i < add_num; i++) {
            	
            	// 첫번째 입력 문자 "I"는 사용하지 않고 버림
            	String trash = st.nextToken();
            	
            	// 두번째 입력 숫자는 LinkedList의 어느 위치에 넣을 지 나타냄
            	int pos = Integer.parseInt(st.nextToken());
            	
            	// 세번째 입력 숫자는 다음 "I" 전까지 몇 개의 숫자를 받을 지 나타냄
            	int repeat = Integer.parseInt(st.nextToken());
            	
            	// 새로운 숫자들을 repeat만큼 LinkedList에 추가함
            	for(int j = 0; j < repeat; j++) {
            		list.add(pos, Integer.parseInt(st.nextToken()));
            		
            		// pos를 그냥 놔두면 계속 고정된 위치에 숫자가 추가되기 때문에
            		// pos를 늘려가면서 앞에 추가된 숫자 뒤에 숫자가 추가되게끔 해줌
            		pos++;
            	}
            	
            }
            
            System.out.print("#" + testCase + " ");
            
            int count = 0;
            while(!list.isEmpty()) {
            	if(count > 9)
            		break;
            	System.out.print(list.poll() + " ");
            	count++;
            }
            System.out.println();
        }
        
    }    
}
