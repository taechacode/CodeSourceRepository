class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        for(int location = 0; location < seoul.length; location++) {
            if(seoul[location].equals("Kim")) {
                answer = "김서방은 " + location + "에 있다";
                break;
            }
        }
        
        return answer;
    }
}