> https://leetcode.com/problems/third-maximum-number/

```java

import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        
        for (int i : nums) {
            if (pq.contains(i)) {
                continue;
            }
            pq.add(i);
        }
        
        if (pq.size() >= 3) {
            pq.poll();
            pq.poll();
        }
        
        return pq.poll();
    }
}
```

- 제한사항
    - `-2^31 <= nums[i] <= 2^31 - 1`
        - int 범위 이내인듯 [참고](http://www.tcpschool.com/java/java_datatype_basic)

- 시간복잡도
    - O(N)

- 기타
    - PriorityQueue 자료 구조를 이용하면, 순서를 정해서 데이터를 넣을 수 있음.
    - 이 방법 말고, `Integer`, wrapper class를 이용해서 푸는 방법도 있는 듯 
        - [참고](https://leetcode.com/problems/third-maximum-number/discuss/90202/Java-neat-and-easy-understand-solution-O(n)-time-O(1)-space)