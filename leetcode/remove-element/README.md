```java
// https://leetcode.com/problems/remove-element/
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        
        int length = nums.length;
        int targetLength = 0;
        for(int i = 0; i < length; i++) {
            if (nums[i] == val) {
                targetLength++;
                nums[i] = 51;
            }
        }
        Arrays.sort(nums);
        
        return length - targetLength;
    }
}
```

- Complexity
  - O(N^2) (due to arrys.sort()...)

- Constraint
  - in place (without no extra memory)
  - nums[i] is less than 50
  - nums.length can be 0 (check this before process code)
