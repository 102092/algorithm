> https://leetcode.com/problems/move-zeroes/

```java
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        
    }
}
```

- 제한사항
    - `1 <= arr.length <= 10^4`
        - arr length 1일 경우, edge case 확인하는 조건이 필요할듯.
    - `-2^31 <= nums[i] <= 2^31 - 1`

- 시간복잡도
    - O(N)


