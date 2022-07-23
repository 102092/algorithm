```python
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        answer = [0] * len(temperatures)
        
        for i, curr in enumerate(temperatures):
            # i index
            # curr current temperature
            # list[-1] means last elements
            
            while stack and curr > temperatures[stack[-1]]:
                last = stack.pop()
                answer[last] = i - last
            stack.append(i)
        
        return answer
```

- 이해
    - stack 에는 인덱스만 담긴다.
    - 현재 온도 > `stack[-1]`  인 순간 즉 어떤 시점보다 현재 온도가 더 높은 순간, 얼마나 걸렸는지 알 수 있음.

- 시간복잡도
    - O(N)

- 기타
    - list[-1] means last elements
    - 리스트 값을 초기화 해줘야함.