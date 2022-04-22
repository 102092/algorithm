```java
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        try {
            int result = Integer.parseInt(s);
            return result;
        } catch(Exception ignore) {}
        
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        
        return Integer.parseInt(s);
    }
}

```

- 제한사항
    - 딱히 없었음.
    - 주어진 `s` 가 Int로 바로 변환될 수 있는 값이 온다는 점

- 시간복잡도
    - O(1)