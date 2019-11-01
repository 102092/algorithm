

## 강의풀이

```java

package app;

import java.util.*;

public class Kth {
    public static void main(String[] args) throws Exception {
        Kth kth = new Kth();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        System.out.println("array : " + kth.solve_array(nums, k));
        System.out.println("pq : " + kth.solve_pq(nums, k));
    }

    private int solve_pq(int[] nums, int k) {

        int length = nums.length;
        Arrays.sort(nums);

        return nums[length - k];
    }

    private int solve_array(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();

    }

    Comparator<Integer> comp = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            return o1 - o2; // return값이 양수면 자리를 바꿔준다. 즉 오름차순
        }
    };

}
```

## 나의풀이



## 필요개념

- 해결방법이 2개
  1. 배열을 오름차순으로 정렬
  2. `Priority Queue` 를 사용

- 직관적인 방법을 사용하자.
  - Arrays.sort() 를 통해 오름차순.
  - pq 개념을 통해 자동으로 오름차순을 해주고, 조건길이가 넘지 않도록 poll해주면 될듯함.