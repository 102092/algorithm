

## 강의풀이

```java
package coding.test.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Permutation p = new Permutation();
        System.out.println(p.permute_dfs(nums));
    }

    private List<List<Integer>> permute_dfs(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        // null 체크
        if (nums == null || nums.length == 0)
            return res;

        dfs(nums, res, list);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur) {

        // 1 정답을 담아서
        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            res.add(list);
        }

        // for 문 저장 탈출
        for (int i = 0; i < nums.length; i++) {

            if (cur.contains(nums[i]))
                continue;

            cur.add(nums[i]);

            dfs(nums, res, cur);

            cur.remove(cur.size() - 1);
        }
    }

}
```

## 나의풀이



## 필요개념

- DFS
  - 조건이 필요할 것이구,
  - 아마도 재귀적으로 들어갈 것같네

