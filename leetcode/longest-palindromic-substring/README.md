```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        def expand(left: int, right: int) -> str:
            while left >= 0 and right < len(s) : 
                if s[left] == s[right]:
                    left -= 1
                    right += 1
                else:
                    break
            return s[left + 1:right]
        
        # s가 한자리라면, 판단할 필요 없음.
        # s == s[::-1] 이라면 가장 긴 팰린드롬은 s 그 자체
        if len(s) < 2 or s == s[::-1]:
            return s
        
        
        result = ''
        for i in range(len(s) - 1):
            # 2칸(짝수 증가), 3칸(혹수 증가)에 해당하는 윈도우를 통해 파악
            result = max(result, expand(i, i + 1), expand(i, i + 2), key=len)
        return result
        
        
```

- 이해
    - 팰린드롬? 거꾸로 읽어도 똑같은 문장이나 단어
- 제한사항
    - s.length >= 1 즉 1자리의 값도 들어올 수 있다는 뜻 그럼 그대로 리턴하면 될듯.
- 아이디어
    - 다이나믹 프로그래밍으로 풀수도 있음.
    - 투포인터를 이용해서, 중앙에서 확장해나가는 방식
