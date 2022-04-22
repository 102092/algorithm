> https://leetcode.com/problems/remove-duplicates-from-sorted-array/

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr) {
                curr = nums[i];
                nums[count] = curr;
                count += 1;
            }
        }
        return count;
    }
}
```

- 제한사항
    - nums[i] 의 값은 -100 ~ 100까지
    - nums array는 오름차순으로 정렬되어 있음.
    - nums array는 1이상의 길이를 가지고 있음.
    - in-place 문제, 새로운 space 할당하면 안됨.

- 시간복잡도
    - O(N)

- 기타
    - 생각보다 컨셉 잡는게 어려움.
    - 현재값 (curr) 과 `nums[i]` 값이 같지 않다. 즉 유니크한 값이다.
