> https://programmers.co.kr/learn/courses/30/lessons/42577



## 작성 코드

```java
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set;
        Arrays.sort(phone_book);
        set = makeSet(phone_book);

        boolean answer = true;
        
        for (int i = 0; i < phone_book.length; i++) {
            answer = checkPrefix(phone_book[i],set);
            if (answer == false) break;
        }
        return answer;
    }
        private boolean checkPrefix(String str, Set<String> set) {
        set.remove(str);

        Iterator<String> number = set.iterator();

        while (number.hasNext()){
            if(number.next().startsWith(str)){
                return false;
            }
        }
        return true;
    }

    private Set<String> makeSet(String[] input){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }
        return set;
    }
}
```
