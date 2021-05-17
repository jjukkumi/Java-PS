import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int solution(String[][] clothes) {
        return Stream.of(clothes).collect(Collectors.groupingBy(s -> s[1], Collectors.counting()))
                .values()
                .stream()
                .reduce(1L, (a, b) -> a * (b + 1))
                .intValue() - 1;
    }
}