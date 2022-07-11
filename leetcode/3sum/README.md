```python
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        
        
        for i in range (len(nums) - 2):
            # 중복된 리스트가 result에 들어가는 것을 막기 위해
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            left, right = i + 1, len(nums) - 1
            
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                
                # 합계가 음수라면, left 쪽에서 인덱스를 하나 증가해서, 합계가 음수가 안되도록 유도
                if sum < 0:
                    left += 1
                    
                # 반대로 합계가 0보다 크다면 right쪽 인덱스를 하나 감소 시켜서, 합계가 0이 되도록 유도
                # 이 부분은 모두 nums.sort() 
                elif sum > 0:
                    right -= 1
                else:
                    result.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    
                    # 중복된 리스트가 result에 들어가는 것을 막기 위해
                    while left < right and nums[left - 1] == nums[left]:
                        left += 1
                    while left < right and nums[right + 1] == nums[right]:
                        right -= 1
        return result
```

- 제한사항
    - result로 나오는 리스트는 중복된 트리플을 가지고 있어선 안됨.
    - 즉 [-1, 0 , 1], 과 [0, 1, -1] 은 같은 리스트임.
- 아이디어
    - 3 pointer (i + j + k = 0)
    - two ponter + sort
- 시간 복잡도
    - O(N^2)