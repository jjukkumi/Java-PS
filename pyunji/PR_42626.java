import java.util.*;
import java.util.stream.Collectors;

// sort 하면 효율성에서 통과를 못하기 때문에 우선순위 큐 사용해야함
class Solution_42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priQ = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        
        int answer = 0;
        for(int i = 0; i < scoville.length - 1; i++){
            if(priQ.peek() < K) {
                Integer min1 = priQ.poll();
                Integer min2 = priQ.poll();
                priQ.offer(min1 + min2 * 2);
                answer++;
            } else {
                return answer;
            }
        }
        // priQ에 남아있는 마지막 하나 요소를 검사
        if (priQ.peek() >= K) return answer;
        return -1;
    }
}
