

## 강의풀이

```java
package coding.test.DP;

public class ClimbingStairs {

    public static void main(String[] args) {
        int input = 4;
        System.out.println(climbingStairs(input));

    }

    private static int climbingStairs(int input) {
        int[] dp = new int[input + 1]; // 0 1 2 3

        if (input == 1)
            return 1;
        if (input == 2)
            return 2;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= input; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[input];

    }

}
```

## 나의풀이



## 필요개념

- DP

  - ~의 경우의 수를 찾는듯?

  - 재사용
    - dp[3] = dp[2] + dp[1]
    - dp[i] = dp[i-1] + dp[i-2]

