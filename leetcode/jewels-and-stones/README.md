```python
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        freqs = collections.Counter(stones)
        count = 0
        for j in jewels:
            if j in freqs:
                count += freqs[j]
        
        return count
```


- 제한사항
    - 대소문자는 구분되어야함.

- 기타
    - `collections.Counter` 는 존재하지 않는 키의 경우 에러를 발생시키는 것이 아닌 0을 출력해줌.