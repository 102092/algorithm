

## 강의풀이

```java

package app;

import java.util.*;

public class MissingRange {
    public static void main(String[] args) throws Exception {
        int[] nums = { 2, 3, 5, 50, 75 };
        int lower = 0, upper = 99;

        System.out.println(solve(nums, lower, upper));
        // [0->1, 6->49, 51->74, 76->99]

    }

    private static List<String> solve(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<>();
      
      //null 체크
        if (nums == null || nums.length == 0)
            return result;

        if (lower < nums[0]) {
            result.add(makeRange(lower, nums[0] - 1)); // 0->1
        }

        for (int i = 1; i < nums.length - 1; i++) { // 3,5,50 까지만 i가 1,2,3
            if (nums[i] != nums[i + 1] && nums[i] + 1 < nums[i + 1]) {
                result.add(makeRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        if (nums[nums.length - 1] < upper) {
            result.add(makeRange(nums[nums.length - 1] + 1, upper));

        }
        return result;
    }

    private static String makeRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }

}
```

## 나의풀이



## 필요개념

- 주어진 숫자간 범위에 해당하는 수를 찾는 문제

- 주어진 값이 나올수 있는 케이스를 만든다.

  1. 0< nums[0] .. 0<2 // 0->1이 기대되고

  2. 2,3 은 패스
  3. 3,5 는 // 4가 프린트 되길 기대
  4. 5, 50 // 6->49
  5. 51-> 74
  6. 76->99