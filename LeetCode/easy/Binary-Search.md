> https://leetcode.com/problems/binary-search/

## 나의풀이

```java
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/ 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```

## 필요개념

- Binary Search 라는 것은 정렬이 되었음 을 의미.
- 이러한 성질을 이용해서 찾는다.
- ![](https://www.geeksforgeeks.org/wp-content/uploads/Binary-Search.png)
- 시간복잡도 O(LogN)
- 중심값을 기준으로 크면, 찾는 값이 오른쪽에 있다는 의미니까, 중심값 Index + 1 부터 마지막 까지 찾으면 되고,
- 작으면, 찾는 값이 왼쪽에 있다는 의미니까, 처음부터, 중심값 index -1 까지 찾으면 된다.
