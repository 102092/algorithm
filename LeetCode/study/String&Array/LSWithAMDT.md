## 강의풀이

```java
package app;

import java.util.*;

public class LSWIth {
    public static void main(String[] args) throws Exception {
        // 가장 긴 길이, 최대 2가지다른 문자의
        String s = "ccaabbb";
        System.out.println(solve(s));

    }

    private static int solve(String s) {

        // 문자의 갯수 관리
        int start = 0, end = 0, length = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1); // c = 2 , a = 2, b = 3
            if (map.get(endChar) == 1)
                counter++;
            end++;

            while (counter > 2) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0)
                    counter--;
                start++;

            }
            length = Math.max(length, end - start);
        }

        return length;
    }

}
```

## 나의풀이



## 필요개념

- Map
- Two Pointer



![](http://mblogthumb4.phinf.naver.net/MjAxNzA1MTBfOTYg/MDAxNDk0NDIwMDQ0MTk1.UnektPcI9rEuhkmfCGKNrI4Ln99ReoBUZSWZ-Uz9LWAg.3iAOQXxjK-RQRN1oEE2YAvsXS_cA8J0PrVz5-xHCwUYg.PNG.heartflow89/image.png?type=w800)

- map.get()

- map.getOrDefault();

  default [V](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html) getOrDefault([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html) key, [V](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html) defaultValue)

  찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.

- 다시 들어볼것.