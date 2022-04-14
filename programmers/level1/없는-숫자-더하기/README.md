```java

class Solution {
    public int solution(int[] numbers) {
        int[] number = new int[10];
        
        for (int i = 0; i < numbers.length; i++) {
            number[numbers[i]]++;
        }
        
        int result = 0;
        
        for (int i = 0; i < number.length; i++) {
            if (number[i] == 0) {
                result += i;
            }
        }
        
        return result;
        
    }
}

```

- 제한사항
    - 딱히 없었음.

- 시간복잡도
    - O(N)

- 생각할만한 내용
    - 0 ~ 9 까지 모두 더한 다음 (45), numbers 배열의 총합을 빼줘도 괜찮을듯.