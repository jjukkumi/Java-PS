import java.util.Arrays;

class Solution{
    int answer;

    public int solution(int[] numbers, int target) {
        /* for문의 break문을 위해 정렬해주었다. */
        Arrays.sort(numbers);
        answer = 0;
        int init = 0;

        /* 모든 숫자를 더한다. */
        int sumInts = Arrays.stream(numbers).reduce(0, Integer::sum);

        dfs(sumInts, numbers, target, init);
        return answer;
    }

    public void dfs(int sumInts, int[] numbers, int target, int init) {
        for (int i = init; i < numbers.length; i++) {
            /* 1-2+1+2+3 = (1+2+1+2+3) - 2*2 */
            int checkInt = sumInts - 2 * numbers[i];
            /* numbers를 sort했기 때문에, 타겟보다 작으면 더이상 뺄 필요가 없으므로 break 한다. */
            if (checkInt < target) {
                break;
            } else if (checkInt == target) {
                answer++;
            } else {
                dfs(checkInt/* 계산한 값을 갱신한다 */, numbers, target, i+1/* for문이 다음 순서부터 돌게 한다 */);
            }
        }
    }
}