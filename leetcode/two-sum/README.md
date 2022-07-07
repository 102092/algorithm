```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
```
- 이해 
    - 2개의 수를 더해서 target이 되는 
- 아이디어
    - 브루드 포스 즉 배열을 두번 반복하면서 원하는 숫자(target) 가 나오는지 확인 
- 시간 복잡도
    - O(N^2)

---

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i, n in enumerate(nums):
            complement = target - n
            #print('c ',complement)
            if complement in nums[i + 1:]:
             #   print('n ',n)
                return [nums.index(n), nums[i+1:].index(complement) + i +1]
```

- 아이디어
    - enumerate() 함수 이용.
    - 시간복잡도는 O(^2) 이지만 위 풀이보다 빠름.


---

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
         
        for i, n in enumerate(nums):
            if target - n in map:
                return [map[target-n], i]
            map[n] = i
        
```
- 아이디어
    - dict 사용

- 시간복잡도 
    - O(N)