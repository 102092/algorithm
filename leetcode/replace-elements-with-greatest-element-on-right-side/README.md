> https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

```java
class Solution {
    
    // [17,18,5,4,6,1]
    // arr.length = 6;
    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        
        for (int i = 0; i < arr.length - 1; i ++) {
            arr[i] = getMaxFrom(arr, i + 1, arr.length);
        }
        
        
        arr[arr.length - 1] = -1;
        return arr;
    }
    
    public int getMaxFrom(int[] arr, int startIndex, int lastIndex) {
        int result = arr[startIndex];
        
        for (int i = startIndex + 1; i < lastIndex; i++) {
            if (result < arr[i]) {
                result = arr[i];
            }
        }
        
        return result;
    }
}

```

- 제한사항
    - `1 <= arr.length <= 10^4`
        - arr length 1일 경우, base 조건이 필요할듯.
        - 이중 for-loop 돌려도 괜찮을듯..?
    - `1 <= arr[i] <= 10^5`

- 시간복잡도
    - O(N^2)

