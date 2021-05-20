import java.util.*;
import static java.util.stream.Collectors.*;

class Solution_test {
    public int solution(int[] priorities, int location) {
        /* priorities를 우선순위가 높은 순서로 정렬한 배열 생성 */
        ArrayList<Integer> ordPriArr = Arrays.stream(priorities).boxed()
        .sorted(Comparator.reverseOrder()).collect(toCollection(ArrayList::new));

        /* 큐에 주어진 priorities와 그 인덱스를 저장 */
        Queue<Integer> priQueue = new LinkedList<>();
        Queue<Integer> idxQueue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            priQueue.offer(priorities[i]);
            idxQueue.offer(i);
        }


        int answer = 0;

        /* 높은 우선순위부터 순회 */
        for (Integer k : ordPriArr) {
            Integer pri = priQueue.peek();
            Integer idx = idxQueue.peek();
            /* 현재 우선순위와 k가 일치할 때 까지 priQueue와 idxQueue의 요소를 빼고넣고 반복 */
            while (!k.equals(pri)){
                priQueue.offer(priQueue.poll());
                idxQueue.offer(idxQueue.poll());
                pri = priQueue.peek();
                idx = idxQueue.peek();
            }
            /* 일치하는 경우 answer에 1을 더함 */
            /* 예를 들어 answer이 3인 경우 현재 우선순위의 출력물은 3번째로 출력된다는 의미*/
            answer += 1;
            /* 일치한 요소들은 Queue에서 빼줌 */
            priQueue.poll();
            idxQueue.poll();
            /* 주어진 location과 현재의 idx가 일치하면 for문을 빠져나옴 */
            if(idx.equals(location)) return answer;

        }

        return answer;
    }
}