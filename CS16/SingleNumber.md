> https://leetcode.com/problems/single-number/



## 작성 코드

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        return getSingleNumber(nums);
    }
    private int getSingleNumber(int[] input) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < input.length ; i++) {
            if(set.contains(input[i])){
                set.remove(input[i]);
            }else{
                set.add(input[i]);
            }
        }

        return (int) set.toArray()[0];
    }

}
```
