> https://leetcode.com/problems/two-sum/



## 작성 코드

```java
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap();
    int[] result = {};
       for (int i = 0; i < nums.length; i++) {
            int wanted = target - nums[i];
            if(map.containsKey(wanted)){
                result = new int[] {map.get(wanted), i};
            }
            map.put(nums[i], i);
        }
       return result;
    }
}
```



## 다른 코드

```java
  
```
