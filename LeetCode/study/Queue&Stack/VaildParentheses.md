

## 강의풀이

```java
package app;

import java.util.*;

public class VaildParentheses {
    public static void main(String[] args) throws Exception {
        // String input = "{[]}";
        String input = "{}[]()";
        // String input = "([)]";

        System.out.println(isValid(input));

    }

    private static boolean isValid(String input) {
        Stack<Character> stk = new Stack<>();
        if (input.length() % 2 != 0) // 길이가 짝수가 아니면 어차피 짝이 지어지지 않을 테니
            return false;

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
            case ')':
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                }
                break;
            case '}':
                if (!stk.isEmpty() && stk.peek() == '{') {
                    stk.pop();
                }
                break;
            case ']':
                if (!stk.isEmpty() && stk.peek() == '[') {
                    stk.pop();
                }
                break;

            default:
                stk.push(input.charAt(i));
                break;
            }
        }
        return stk.isEmpty(); // 비어 있으며 true, 남아있으면 false
    }
}
```

## 나의풀이



## 필요개념

- 핵심, stack을 이용해야되는 문제인지 파악해야함.

- 함정이 있음.