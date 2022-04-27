> https://leetcode.com/problems/sort-array-by-parity/

```java

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        
        Stack<Integer> even = new Stack<>();
        Stack<Integer> odd = new Stack<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                even.push(nums[i]);
            } else {
                odd.push(nums[i]);
            }
        }
        
        int index = 0;
        
        while (!even.isEmpty()) {
            nums[index] = even.pop();
            index++;
        }
        
        while (!odd.isEmpty()) {
            nums[index] = odd.pop();
            index++;
        }
        
        
        return nums;
        
    }
}
```

- 제한사항
    - `1 <= nums.length <= 5000`
        - length가 1일떄가 있으니까 이 edge case 확인해야할듯.

- 시간복잡도
    - O(N)

- 기타
    - in-place 혹은 two pointer로 무넺를 해결할 수 도 있을듯하다.