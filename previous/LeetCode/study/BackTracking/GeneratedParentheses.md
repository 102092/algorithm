

## 강의풀이

```java
package coding.test.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * GP
 */
public class GP {

    public static void main(String[] args) {
        GP g = new GP();
        System.out.println(g.gerateParentheses_dfs(3));

    }

    private List<String> gerateParentheses_dfs(int i) {
        List<String> res = new ArrayList<>();
        dfs(res, "", i, i, "");
        return res;
    }

    int count = 0;

    private void dfs(List<String> res, String str, int left, int right, String test) {
        count++;
        // System.out.println(
        // "str\t" + str + "\t left: " + left + " right: " + right + " count: " + count
        // + " test: " + test);
        // 1 제약조건
        if (left < 0 || left > right)
            return;
        // 2
        System.out.println(
                "str\t" + str + "\t left: " + left + " right: " + right + " count: " + count + " test: " + test);

        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        // 3 dfs 재귀적으로 호출
        dfs(res, str + "(", left - 1, right, test + "+");
        dfs(res, str + ")", left, right - 1, test + "-");
    }

}
```

## 나의풀이



## 필요개념

- DFS 문제
  - 왜? 파고들어야한다.

- 잘 이해 안되는 문제. 직접 손으로 써보자

- 문제 해석
  - input 3을 넣으면, 이 내에서 만들어질 수 있는 `'()'` 경우의 수를 출력해줘야한다.
  - 제약조건이 필요할 것이구.
  - 왼쪽 오른쪽 이렇게 나눠서 생각해봐야하지 않을까?

- 제약조건이 핵심. 파고들면서 세운 기준을 벗어나지 않도록, 혹은 원하는 조건을 만족할 경우 그것을 기록하도록 해줘야함.

