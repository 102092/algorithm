```python
class Solution:
    def isPalindrome(self, s: str) -> bool:
        strs = [] # 리스트 선언
        #  strs = collections.deque() deque로 선언
        
        
        # str -> char 을 모두 넣는데, 
        for char in s:
            if char.isalnum():
                strs.append(char.lower())
                
        while len(strs) > 1:
            if strs.pop(0) != strs.pop(): # if strs.popleft() != strs.pop(): 
                return False
        
        return True
        
```

- 아이디어
    - 리스트에 순서대로 String을 쪼개서 char을 넣음.
    - 이때, `isalnum()` 을 이용해서, **영문자와 숫자** 만 넣는다. (공백 문자를 제외하기 위함)
    - 그리고 `lower()` 을 이용해서, 소문자로 변환한다. (after converting all uppercase letters into lowercase letters..)
    - `pop(0)`를 통해서 리스트 맨앞요소와, `pop()` 을 통해서, 리스트 맨 마지막 요소가 같은지 판단

- 시간복잡도
    - O(N)

- 기타
    - 리스트 말고, `Deque` 자료구조를 이용하면, 더 효율적으로 사용할 수 있음.
    - 왜?
    - `Deque` 의 `popleft()` 는 O(1) 반면 리스트의 `pop(0)` 는 O(n)


---

```python
class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        
        s = re.sub('[^a-z0-9]', '', s)
        
        return s == s[::-1]

```

- 풀이
    - `re.sub('[^a-z0-9]', '', s)` 를 통해, 영문자, 숫자가 아닌 것은 `''` 로 대체하도록 정규식 처리
    - 그리고 해당 문자를 슬라이싱을 이용해서 뒤집음 `[::-1]`
    - `==` 으로 값 비교 
        - cf) `is` 는 `id()` 값을 비교

- 참고
    - https://securityspecialist.tistory.com/60