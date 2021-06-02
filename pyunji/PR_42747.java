import java.util.Arrays;

class Solution_42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int len = citations.length;

        /* h-index는 논문의 개수에 의존하므로 1 <= h-index <= citations.length */
        for (int hIndex = 1; hIndex <= citations.length; hIndex++) {
            /* 만약 현재 h-index가 2면, 뒤에서 두번째 값은 2보다 같거나 커야함 */
            /* 만약 현재 h-index가 2면, 2 이상인 값이 2개 이상이어야 하니까 */
            if(citations[len - hIndex]<hIndex) break;
            answer = hIndex;
        }
        return answer;
    }
}