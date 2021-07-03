import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String numbers) {
        /* 주어진 숫자를 조합해 만들 수 있는 최대 정수 */
        int maxInt = Integer.parseInt(
                Arrays.stream(numbers.split(""))
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.joining()));

        int count = 0;
        /* 최대 정수 까지의 모든 숫자를 순회 */
        for(int i = 2; i <= maxInt; i++) {
            /* 주어진 숫자로 만들어졌고, 소수라면 카운트 */
            if(isMadeWithGivenNumbers(i, numbers) && isPrimeNum(i)) count++;
        }
        return count;
    }

    /* 소수인지 확인 */
    public boolean isPrimeNum(int targetNum){
        for (int i = 2; i <= (int)Math.sqrt(targetNum); i++) {
            if (targetNum % i == 0) return false;
        }
        return true;
    }

    /* 주어진 숫자로 만들 수 있는 수인지 확인 */
    public boolean isMadeWithGivenNumbers(int targetNum, String numbers){
        String[] targetStr = String.valueOf(num).split("");
        int len = targetStr.length;
        int count = len;
        for(int i = 0; i < len; i++) {
            if(numbers.contains(targetStr[i])) {
                count--;
                numbers = numbers.replaceFirst(targetStr[i], "");
            }
        }
        return count==0;
    }

}