import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        if(Arrays.stream(numbers).max().getAsInt()==0) return "0";

        return Arrays.stream(numbers).boxed()
                .map(integer -> integer + "")
                .sorted(Comparator.comparing((String s) -> s.repeat(4)).reversed())
                .reduce((s1, s2) -> s1 + s2).get();
    }
}