

## 강의풀이

```java
package coding.test.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Letter {

    public static void main(String[] args) {
        Letter l = new Letter();
        System.out.println(l.solve("23"));
    }

    private List<String> solve(String digits) {
        String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> res = new ArrayList<>();

        if (digits.length() == 0)
            return res;

        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            res = combine(res, digitletter[digits.charAt(i) - '0']);
        }
        return res;
    }

    private List<String> combine(List<String> res, String digit) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < digit.length(); i++) {
            for (String firstStr : res) {
                result.add(firstStr + digit.charAt(i));
            }
        }
        return result;
    }

}
```

input : 23 // String type

output : [ad, bd, cd, ae, be, ce, af, bf, cf] // list type. 아마 arrayList로 만들어야겠지?



## 나의풀이

```java
package coding.test.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Letter {

    public static void main(String[] args) {
        Letter l = new Letter();
        System.out.println(l.solve("23"));
    }

    private List<String> solve(String digits) {
        String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> res = new ArrayList<>();

        if (digits.length() == 0)
            return res;

        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            res = combine(res, digitletter[digits.charAt(i) - '0']);
        }
        return res;
    }

    private List<String> combine(List<String> res, String digit) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < digit.length(); i++) {
            for (String str : res) {
                sb.append(str).append(digit.charAt(i));
                // result.add(str + digit.charAt(i));
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result;
    }

}
```

- using `Stringbuilder`



## 필요개념

- 이중 for 문
- "" + a, b, c + d // e // f
- `[digits.charAt(i) - '0'] `

