> https://leetcode.com/problems/height-checker/


```java
class Solution {
    public int heightChecker(int[] heights) {
        if (heights.length == 1) {
            return 1;
        }
        
        int length = heights.length;
        int[] copiedHeights = Arrays.copyOf(heights, length);
        Arrays.sort(copiedHeights);
        
        int result = 0;
        
        for (int i = 0; i < length; i++) {
            if (heights[i] != copiedHeights[i]) {
                result++;
            }
        }
        
        return result;
        
    }
}

```

- 제한사항 
    - `1 <= heights.length <= 100` , length == 1일 경우 확인해야함

- 시간복잡도
    - `O(N^2)` 
    - `Arrays.sort` 떄문에..

- 기타
    - Arrays.copyOf() ..
    - [counting sort](https://bowbowbow.tistory.com/8)