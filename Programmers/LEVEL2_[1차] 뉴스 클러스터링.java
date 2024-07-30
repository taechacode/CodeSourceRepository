import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        	        
	    // str1 List
	    ArrayList<String> str1List = new ArrayList<>();
	        
	    // str2 List
	    ArrayList<String> str2List = new ArrayList<>();     
	        
	    // inter Count
	    int interCount = 0;
        
        // union Count
	    int unionCount = 0;
	            
        // 1. 입력 문자열을 비교하기 쉽게 소문자로 변환
	    str1 = str1.toLowerCase();
	    str2 = str2.toLowerCase();
	    
        // 2. 알파벳 문자열만 List에 추가
	    for(int i = 0; i < str1.length() - 1; i++) {
	        if((str1.charAt(i) >= 97) && (str1.charAt(i) <= 122) 
	           && (str1.charAt(i + 1) >= 97) && (str1.charAt(i + 1) <= 122)) {
	            str1List.add(str1.substring(i, i + 2));
	        }
	    }
	        
	    for(int i = 0; i < str2.length() - 1; i++) {
	        if((str2.charAt(i) >= 97) && (str2.charAt(i) <= 122) 
	           && (str2.charAt(i + 1) >= 97) && (str2.charAt(i + 1) <= 122)) {
	           	str2List.add(str2.substring(i, i + 2));
	        }
	    }
	    
        // 3. str1 List에서 str2 List을 제외시키기
	    ArrayList<String> onlyStr1List = new ArrayList<>(str1List);
        
        for(String s : str2List) {
            onlyStr1List.remove(s);
        }
	    
        // 4. 교집합 크기 구하기
        interCount = str1List.size() - onlyStr1List.size();
        
        // 5. 합집합 크기 구하기
        unionCount = str1List.size() + str2List.size() - interCount;
        
        // 예외처리1. 교집합과 합집합의 크기가 모두 0일 경우에만 65536 return
        if(interCount == 0 && unionCount == 0) {
            return 65536;
        }
        
        // 예외처리2. 교집합과 합집합의 크기가 모두 0일 경우에만 65536 return
        if(interCount == 0) {
            return 0;
        }
        
        // 6. 제수와 피제수를 구하여 정답 계산
	    double divd = interCount;
	    divd = divd > 0 ? divd : 1;

	    double divr = unionCount;
	    divr = divr > 0 ? divr : 1;      
	    
        int answer = (int) Math.floor(divd / divr * 65536);
	        
	    return answer;
    }
}