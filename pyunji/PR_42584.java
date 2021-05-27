import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] prices) {
        /* answerArr을 1로 채우고(상승했든 하락했든 1일은 무조건 지나기 때문) 마지막 요소는 0으로 바꿔줌 */
        List<Integer> answerArr = IntStream.generate(() -> 1).limit(prices.length).boxed().collect(Collectors.toList());
        answerArr.set(prices.length - 1, 0);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            /* 현재 주식 가격이 이전 주식 가격보다 하락한경우 or 현재 주식 가격이 마지막 날의 주식 가격인 경우*/
            while (!stack.isEmpty() && (prices[stack.peek()] > cur || i == prices.length - 1)) {
                /* 현재 날짜와 이전 날짜를 뺀 값을 answerArr에 셋팅한다 */
                Integer last = stack.pop();
                answerArr.set(last, i - last);
            }
            /* stack의 요소는 이전 주식가격보다 이후 주식가격이 상승한 경우의 인덱스만 들어있다 */
            stack.push(i);
        }
        
        return answerArr.stream().mapToInt(i->i).toArray();
    }
}