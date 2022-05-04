> https://leetcode.com/problems/squares-of-a-sorted-array/

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        // two pointer
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int index = nums.length - 1;
        
        while (index > -1) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[index] = (int) Math.pow(nums[i], 2);
                i++;
                
            } else {
                result[index] = (int) Math.pow(nums[j], 2);
                j--;
            }
            index--;
        }
    
        return result;
    }
}

```

- 아이디어
    - 2개의 포인터를 통해, 배열의 맨처음 맨뒤에서 시작해서,  i,j 크기를 비교하면서 오름차순으로 새로운 배열 쌓아가는 것.
    - 굳이 while문으로 돌리지 않고 for문으로 해도 되었을듯.

- 제한사항
    - nums is sorted in non-decreasing order.

- 시간복잡도, 공간복잡도
    - O(N)

- 기타

