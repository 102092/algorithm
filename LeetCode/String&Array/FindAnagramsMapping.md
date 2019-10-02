## 강의풀이

```java
package app;

import java.util.*;

public class FindAnagramsMapping {
    public static void main(String[] args) throws Exception {
        int[] A = { 11, 27, 45, 31, 50 };
        int[] B = { 50, 11, 31, 45, 27 };

        int[] result = anagramMapping(A, B);
        System.out.println(Arrays.toString(result));
    }

    private static int[] anagramMapping(int[] a, int[] b) {
        int[] result = new int[a.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(b[i], i); // 1 4 3 2 0
        }
        for (int j = 0; j < a.length; j++) {
            result[j] = map.get(a[j]);
        }

        return result;
    }
}
```

## 나의풀이



## 필요개념

- Map
- Array B의 순서를 리턴하라.
  1. `int[]`
  2. Map을 가지고 A의 값을 셋팅
  3. 꺼낼때는 B key 값으로 리턴되는 걸 `int[]` 에 넣는다.

