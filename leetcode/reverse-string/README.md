```python
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        s.reverse()
        # s[:] = s[::-1]
        
```

- 제한사항
    - 추가적인 *메모리 할당 없이*, input array를 바꿔야함.

- 아이디어
    - 리스트 자체를 `reverse` 하는 방법이 있지 않을까?
    - https://stackoverflow.com/questions/3940128/how-to-reverse-a-list


---

```python
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        left, right = 0, len(s) - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
        
        
```

- 아이디어
    - **two pointer**

- 이해
    - left, right 인덱스를 할당해놓고 (0, 리스트의 사이즈에서 -1)
    - 현재 인덱스들을 기준으로 스왑.
    - 인덱스 변경
    - left == right 인 경우에는 스왑이 되면 안됨.