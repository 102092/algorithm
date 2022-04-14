```java
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }
}

```

- 제한사항
    - 오름차순
    - 서로 다른 인덱스 일때만 더할것.

- 시간복잡도
    - O(N^2)

- 기타사항
    - Sorting a Set ?
        - `Collections.sort()` 혹은 `TreeSet` 이용을 고려해볼 것