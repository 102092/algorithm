```python
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        out = []
        p = 1

        for i in range(len(nums)):
            out.append(p)
            p = p * nums[i]

        p = 1

        # i = 3, out[3] = 6, p = 4
        # i = 2, out[2] = 8, p = 12
        # i = 1, out[1] = 12, p = 24
        # i = 0, out[0] = 24, p = 24
        for i in range(len(nums) - 1, -1, -1):
            out[i] = out[i] * p
            p = p * nums[i]

        return out
```


- 이해
     - 쉽지 않음.

- 아이디어
    - 왼쪽 출발, 오른쪽 춟발

- 기타
    - `range(start, stop, step)`