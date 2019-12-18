## 강의풀이

```java
package coding.test.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = { 1, 2, 3 };
        System.out.println(s.subSets_dfs(nums));
    }

    private List<List<Integer>> subSets_dfs(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        dfs(nums, res, lists, 0);

        return res;

    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int start) {

        List<Integer> list = new ArrayList<>(cur);
        res.add(list);

        for (int i = start; i < nums.length; i++) {

            cur.add(nums[i]);

            dfs(nums, res, cur, i + 1);

            cur.remove(cur.size() - 1);
        }
    }

}
```

## 나의풀이



## 필요개념

- Subsets == 부분집합
- DFS
  - 재귀적으로 파고 들겠고,
  - 어떤 재약 조건을 파악하느냐가 핵심이겠네

