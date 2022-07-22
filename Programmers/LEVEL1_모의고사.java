import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int answer1 = 0, answer2 = 0, answer3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == person1[i%person1.length]) answer1++;
            if(answers[i] == person2[i%person2.length]) answer2++;
            if(answers[i] == person3[i%person3.length]) answer3++;
        }
        
        int max = Math.max(Math.max(answer1, answer2), answer3);       
        ArrayList<Integer> list = new ArrayList<>();
        if(answer1 == max) list.add(1);
        if(answer2 == max) list.add(2);
        if(answer3 == max) list.add(3);
        Collections.sort(list);
        
        answers = new int[list.size()];
        for(int i = 0; i < answers.length; i++) {
            answers[i] = list.get(i);
        }
        
        return answers;
    }
}