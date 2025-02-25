package SBufferBuilder;

import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String[] inputArray = new String[3]; // 입력받은 문자열을 저장하는 Array
		int i = 1; // 현재 탐색 지점을 저장하는 i
		
		for(int input = 0; input < 3; input++) {
			inputArray[input] = br.readLine();
			
			if(isInteger(inputArray[input])) { // 입력받은 문자열이 숫자라면
				i = Integer.parseInt(inputArray[input]) - input; // i값을 유추 가능
				System.out.println(calcFizzBuzz(i + 3)); // 결과 반환
				return;
			}
		}	
		
		boolean fizzBuzzYn = false; // FizzBuzz 문자열 판단 여부 저장
		
		// inputArray의 문자열이 모두 현재 탐색 중인 i ~ i + 2의 FizzBuzz 문자열인지 판단
		while(true) {
			
			for(int j = 0; j < 3; j++) {
				if(calcFizzBuzz(i + j).equals(inputArray[j])) {
					fizzBuzzYn = true;
				} else {
					fizzBuzzYn = false;
					break;
				}
			}
			
			if(fizzBuzzYn) {
				break;
			} else {
				i++;
			}
			
		}
		
		System.out.println(calcFizzBuzz(i + 3));
		
	}
	
	// 숫자형 유무를 반환하는 Method
	private static boolean isInteger(String str) {
	    return str != null && str.matches("-?\\d+");
	}
	
	// 입력받은 숫자값에 대한 FizzBuzz 문자열을 반환하는 Method
	private static String calcFizzBuzz(int n) {
		
		if(n % 3 == 0 && n % 5 == 0) {
			return "FizzBuzz";
		} else if(n % 3 == 0 && n % 5 != 0) {
			return "Fizz";
		} else if(n % 3 != 0 && n % 5 == 0) {
			return "Buzz";
		} else {
			return String.valueOf(n);
		}
		
	}
	
}
