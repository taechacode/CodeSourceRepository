import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 목표 우선순위 저장.
        int objectPriority = priorities[location];
        
        // 우선순위 배열을 Queue에 적재.
        Queue<Integer> queue = new LinkedList<>();
        for(int pri  = 0; pri <  priorities.length; pri++) {
            queue.add(priorities[pri]);
        }
        
        // 우선순위를 오름차순으로 정렬.
        Arrays.sort(priorities);
        
        int checkPriority = priorities.length - 1;
        while(!queue.isEmpty()) {
            
            // 1. 배열에서 맨 앞에 있는 우선순위를 꺼내온다.
            int currentPriority = queue.poll();            
            
            // 2. 가장 높은 우선순위와 배열에서 꺼내온 우선순위를 비교하여 일치하면
            if(priorities[checkPriority] == currentPriority) {
                
                // 2-1. 가장 높은 우선순위와 목표 우선순위가 일치하고, 해당 우선순위가 목표라면
                if(priorities[checkPriority] == objectPriority && location == 0) {
                    answer++;
                    break;
                }
                
                // 2-2.큐에 넣지 않고 제거 후 다음 우선순위를 비교한다.
                checkPriority--;
                answer++;
                location = location == 0 ? queue.size() : location - 1;
                continue;           
            }
            
            // 3. 일치하지 않으면 목표 우선순위의 값만 감소시키거나 현재 QUEUE의 맨 뒤로 갱신한다.
            location = location == 0 ? queue.size() : location - 1;
            
            queue.add(currentPriority);            
        }
                
        return answer;
    }
}