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
        /* 2가 주어진 숫자로 만들 수 있는지 먼저 검사 */
        if(isMadeWithGivenNumbers(2, numbers)) count++;
        /* 최대 정수 까지의 모든 숫자를 순회 */
        for (int i = 3; i <= maxInt; i=i+2) {
            /* 주어진 숫자로 만들어졌고, 소수라면 카운트 */
            if(isMadeWithGivenNumbers(i, numbers) && isPrimeNum(i)) count++;
        }
        return count;
    }

    /* 소수인지 확인 */
    public boolean isPrimeNum(int targetNum){
        /* 홀수만 검사한다 */
        for (int i = 3; i <= (int)Math.sqrt(targetNum); i = i + 2) {
            if (targetNum % i == 0) return false;
        }
        return true;
    }

    /* 주어진 숫자로 만들 수 있는 수인지 확인 */
    public boolean isMadeWithGivenNumbers(int targetNum, String numbers){
        String[] targetStr = (targetNum + "").split("");

        List<String> numList = Arrays.stream(numbers.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (String s : targetStr) {
            /* 주어진 수에 포함되어있지 않으면 remove시 false가 반환된다. */
            if(!numList.remove(s)) return false;
        }
        return true;
    }

}