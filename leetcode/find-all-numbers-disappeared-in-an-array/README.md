> https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] count = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                result.add(i);
            }
        }
        
        return result;
        
    }
}

```

- 제한사항
    - 크게 생각할만한 건 없는 듯

- 시간복잡도
    - O(N)

- 기타
    - negative value를 이용해서 푸는 방법도 있는 듯 하지만 이해안됨.
        - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/1583741/TIme%3A-O(n)-Space%3A-O(1)

