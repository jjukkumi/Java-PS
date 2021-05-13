import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer;
        Stream<String> parStream = Stream.of(participant);
        Map<String, Integer> parMap = Arrays.stream(participant).collect(Collectors.toMap(person -> person, person -> 0, (a, b) -> b));

        Arrays.stream(participant).forEach(person -> parMap.put(person, parMap.get(person) + 1));

        Arrays.stream(completion).forEach(person -> parMap.put(person, parMap.get(person) - 1));

        answer = Arrays.stream(participant).filter(person -> parMap.get(person).equals(1)).findFirst().orElse("");

        return answer;
    }
}
