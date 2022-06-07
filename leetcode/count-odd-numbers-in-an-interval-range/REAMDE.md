> https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

```java
class Solution {
    public int countOdds(int low, int high) {
        int totalCount = high - low + 1;
        
        if (isOdd(low) && isOdd(high)) {
            return totalCount / 2 + 1;
        }
        
        return totalCount / 2;
        
    }
    
    public boolean isOdd(int input) {
        return input % 2 != 0;
    }
    
    public boolean isEven(int input) {
        return !isOdd(input);
    }
}

```

- 제한사항
    - `0 <= low <= high <= 10^9`
    
- 시간복잡도
    - O(1)

- IDEA
    - 일단 처음에는 모든 값, 그러니까 low ~ high 까지 모두 for 문을 돌 생각을 함. 그런데 문제가 의도하는 바가 그러진 않을 것 같음. 
    - 뭔가 규칙이 있을 거라 생각. 그렇지만 찾지 못함.
    - 결국엔 [링크](https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/discuss/1815848/Java-5-Lines-Code-with-Explanation-in-Detail-or-0ms-Runtime-or-100-Faster) 를 참고해서 해결.

