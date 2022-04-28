> https://programmers.co.kr/learn/courses/30/lessons/12945

```java
class Solution {
    public int solution(int n) {
    int f[] = new int[n+2];
    int i;
        
    f[0] = 0;
    f[1] = 1;
     
    for (i = 2; i <= n; i++) {
        f[i] = (f[i-1] + f[i-2]) % 1234567 ;
    }
      
    return f[n];
    }
}

```

- 제한사항
    - n은 2 이상 100,000 이하인 자연수입니다.

- 시간복잡도
    - O(N)

- 기타
    - n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴
    - 특정 순번의 피보나치 값에서 1234567을 나눈 나머지를 리턴하면 되겠지? -> 안됨, 혹시나 for문 안에 넣어보니 통과
    - https://programmers.co.kr/questions/3832 참고해봤지만 왜 이렇게 구해야하는 지 이해안됨. 
    - https://programmers.co.kr/questions/11991 정리보니 조금 이해되었음. 정수 범위에 대한 문제 였음.
        - `(A + B) % C = ( ( A % C ) + ( B % C) ) % C`
