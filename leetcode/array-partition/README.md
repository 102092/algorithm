```python
class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        sum = 0
        pair = []
        nums.sort() # 오름차순 정렬
        
        for i in nums:
            pair.append(i)
            
            if len(pair) == 2:
                sum += min(pair)
                pair = []
        return sum
        
```

- 이해
    - 페어 (a1, a2) 의  `min()`을 합산했을 때 최대값을 찾아라.
        - 최대값이 되려면..?
    - 페어는 2개의 인수로 이루어져 있음.
    - 리스트는 2의 배수 길이대로 주어짐. 

- 아이디어
    - 정렬된 상태를 이용하자 (오름차순)

- 기타
    - `.sort(reverse=True)` 내림차순 정렬 문법
    - 주어진 데이터에서 풀 수 있는 방법을 고려한 다음에, 이 방법이 확장될 수 있는지 확인하는 방식으로 풀어도 괜찮을듯.



