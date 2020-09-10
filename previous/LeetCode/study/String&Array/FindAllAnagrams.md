## 강의풀이

```java

package app;

import java.util.*;

public class FindAllAnagrams {
    public static void main(String[] args) throws Exception {

        FindAllAnagrams f = new FindAllAnagrams();
        String txt = "BACDGABCDA";
        String pat = "ABCD";

        System.out.println(f.findAnagrams(txt, pat));
    }

    public List<Integer> findAnagrams(String txt, String pat) {

        List<Integer> result = new ArrayList<>();
        if (txt == null || txt.length() == 0 || pat == null || pat.length() == 0 || txt.length() < pat.length())
            return null;

        int[] patArr = new int[256];

        for (int i = 0; i < pat.length(); i++) {
            patArr[pat.charAt(i)]++;

        }
        for (int i = 0; i < txt.length() - pat.length(); i++) {
            int[] txtArr = new int[256];
            for (int j = 0; j < pat.length(); j++) {
                txtArr[txt.charAt(i + j)]++;
            }

            if (check(patArr, txtArr)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean check(int[] patArr, int[] txtArr) {
        for (int i = 0; i < patArr.length; i++) {
            if (patArr[i] != txtArr[i]) {
                return false;
            }

        }
        return true;
    }
}
```

## 나의풀이



## 필요개념

1. pattern값은 ascii값으로
2. 이중 for 문
3. 같은지 비교



