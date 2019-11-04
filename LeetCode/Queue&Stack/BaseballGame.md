

## 강의풀이

```java

package app;

import java.util.*;

public class BaseballGame {
    public static void main(String[] args) throws Exception {
        String[] input = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        System.out.println(points(input));

    }

    private static int points(String[] input) {
        Stack<Integer> stack = new Stack<>();

        for (String str : input) {
            switch (str) {
            case "C":
                stack.pop();
                break;
            case "D":
                stack.push(stack.peek() * 2);
                break;

            case "+":
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y);
                stack.push(x);
                stack.push(x + y);
                break;

            default:
                stack.push(Integer.valueOf(str));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();

        }
        return sum;
    }
}
```

## 나의풀이



## 필요개념

- 철저히 stack을 이용한 문제.

- C,D ++ 는 따로 관리해야할 것 같다.