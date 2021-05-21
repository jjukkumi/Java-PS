import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /* 기능이 하나인 경우 */
        if (progresses.length<2) return new int[]{1};

        /* 기능이 몇 퍼센트 남았는지 계산 */
        int[] remainArr = Arrays.stream(progresses).map(i -> 100 - i).toArray();

        Stack<Integer> dayStack = new Stack<>();

        /* 기능이 완성되기 까지 며칠 남았는지 계산 */
        for (int i = speeds.length - 1; i > -1; i--) {
            dayStack.push((int) Math.ceil((double) remainArr[i] / speeds[i]));
        }

        ArrayList<Integer> ansArr = new ArrayList<>();
        Integer first = dayStack.pop();
        /* 한번에 배포할 수 있는 기능의 수 */
        int ans = 1;
        while (!dayStack.isEmpty()){
            Integer next = dayStack.pop();
            /* 기능을 배포해도 되는 경우 */
            if (first<next) {
                /* 대기중인 기능의 개수를 ansArr에 넣은 후 1로 초기화 */
                ansArr.add(ans);
                ans = 1;
                /* first값을 더 큰 값인 next로 초기화 */
                first = next;
            /* 기능을 배포하지 못하고 기다려야 하는 경우 */
            } else {
                /* 대기중인 기능의 개수를 하나 추가 */
                ans += 1;
            }
        }
        /* 마지막 배포되는 기능의 개수를 추가 */
        ansArr.add(ans);

        return ansArr.stream().mapToInt(i -> i).toArray();
    }
}