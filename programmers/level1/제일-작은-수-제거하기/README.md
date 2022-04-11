```java
import java.util.*;

class Solution {
    // 배열의 길이가 1이면, [-1] 을 리턴해야함
    
  public int[] solution(int[] arr) {
      if (arr.length == 1) {
          return new int[]{-1};
      }
      
      int[] temp = Arrays.copyOf(arr, arr.length);
      Arrays.sort(temp);
      
      int smallest = temp[0];
      
      List<Integer> result = new ArrayList<>();
      
      for (int i = 0; i < arr.length; i++) {
          if (arr[i] == smallest) {
              continue;
          }
          result.add(arr[i]);
      }
      return result.stream().mapToInt(i -> i).toArray();
      
  }
}

```

- 제한사항
    - 배열의 길이가 1이면, `[-1]` 을 리턴해야함. 배열로.

- 시간복잡도
    - Arrays.sort때문에.. O(N^2) 이 나올수도 있을듯
