## 강의풀이

```java
package app;

public class MaximumSubarray {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {

        int newSum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            newSum = Math.max(nums[i], newSum + nums[i]);
            max = Math.max(newSum, max);
        }

        return max;
    }
}
```

## 나의풀이



## 필요개념

- 배열의 각 인자들을 차례대로 더한 값 중에서 나올 수 있는 가장 큰 수는 무엇인가?
  - 단 배열 인자의 순서는 **연속적**이다
- 코드는 간단하지만 로직은 생각해봐야한다.