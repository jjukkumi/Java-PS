import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] prices) {
        int[] answerArr = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answerArr[i]++;
                if (prices[i]>prices[j]) break;
            }
        }
        return answerArr;
    }
}