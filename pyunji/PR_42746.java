import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] integerNums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(integerNums, (a, b) -> {
            String as = String.valueOf(a);
            String bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as+bs), Integer.parseInt(bs+as));
        });
        
        if (integerNums[0] == 0) return "0";
        return Arrays.stream(integerNums).map(i->String.valueOf(i)).collect(Collectors.joining());
    }
}