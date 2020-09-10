## 강의풀이

```java
package app;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) throws Exception {

        String[] list = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(list));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        //null 체크
        if (strs == null || strs.length == 0)
            return result;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // System.out.println("str : " + str);
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            // System.out.println("key : " + key);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }

        }
        result.addAll(map.values());
        return result;
    }
}
```

## 나의풀이



## 필요개념

- Map(key, value)
- char배열을 정렬하는 방법.

