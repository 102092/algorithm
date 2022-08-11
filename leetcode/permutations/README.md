```python
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        results = [] # [1,2,3], [1,3,2]
        prev_elements = []
        
        def dfs(elements):
            if len(elements) == 0:
                results.append(prev_elements[:])
                return
            
            for e in elements:             
                next_e = elements[:] # list copy 
                next_e.remove(e)           
                                                                
                prev_elements.append(e)    
                dfs(next_e)
                prev_elements.pop()        
        
        dfs(nums)
        return results
                     
```

- 이해
    - 순열
    - 순서가 중요.
    - `[1,2,3]` 과 `[1,3,2]` 는 다른 요소로 취급됨. (중복이 아니다.)

- 아이디어
    - DFS (재귀호출) 
- 시간복잡도
    - O(N)

- 기타
    - 모든 경우의 수가 나와야함.
    - 어떻게 모든 경우의 수가 나올 수 있을지 그려보면 도움이 좀 되는 듯.
    - 처음 보았을 때, 해결방법이 떠오르진 않았음.


--- 

```python
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        return list(itertools.permutations(nums))
                
        
```

- 아이디어
    - `iteratools` 모듈 이용, 순열 구현할 때 유용.
- 기타
    - 
