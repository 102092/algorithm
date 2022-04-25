> https://leetcode.com/problems/check-if-n-and-its-double-exist/

```java
class Solution {
    public boolean checkIfExist(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                
                if (target == arr[j] * 2) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

```

- 제한사항
    - 2 <= arr.length <= 500 
        - arr length가 2미만일 경우는 체크 안해도 되겠다
    - -10^3 <= arr[i] <= 10^3
        - 음수 값도 들어갈 수 있다.

- 시간복잡도
    - O(N^2)

- 기타
    - HashSet과 n % 2 == 0 조건을 이용하면, 좀 더 쉬운 방법이 있을 것 같지만 잘 이해 안됨.
    - https://leetcode.com/problems/check-if-n-and-its-double-exist/discuss/509400/Java-set-1ms-explained
    
