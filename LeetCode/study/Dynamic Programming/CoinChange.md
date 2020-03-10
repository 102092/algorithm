

## 강의풀이

```java
package coding.test.DP;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(amount, coins));

    }

    private static int coinChange(int amount, int[] coins) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
```

## 나의풀이



## 필요개념

- DP
  - Dynamic Programming
    - 답을 알고, 그 전단계를 파악하는 식으로 나아가는 것.
  - 어떻게 캐치할까?
    - 문제를 많이 풀어보는 수밖에없음
- Insert Coin에 따라서, 경우의 수가 갈린다?
  - DFS는 Search와 관련된. 그래서 아님.
- 11에서 1코인을 넣으면 10코인이 남고, 그러면 이제 1,2,5코인으로 나워서 갈 수 있고
  - 11코인을 만들기 위해서 1코인을 11번 쓸 수 도 있지만,
  - 이 문제에서 요구하는 것은 가장 짦은 최단의 경우의 수를 구해야함.
- 최소의 경우수를 찾는다.
  - `Math.min` 사용
- 핵심은 재사용. 

