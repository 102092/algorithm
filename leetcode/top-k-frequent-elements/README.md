```python
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if len(nums) == 1:
            return [1]
        
        # return dictionary(map)
        freqs = collections.Counter(nums)
        # freqs.most_common() -> O(n log n) algorithm.
        
        heap = []
        
        for i in freqs:
            # heappush O(lonN)
            heapq.heappush(heap, (-freqs[i], i))
        
        result = []
        
        for _ in range(k):
            # heappop O(lonN)
            result.append(heapq.heappop(heap)[1])
        
        return result
```

- 아이디어
    - heap 모듈, collections.Counter 이용

---

```python
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if len(nums) == 1:
            return [1]
        
        freqs = collections.Counter(nums)
        freqs = freqs.most_common(k) 
        result = []
        
        for _ in range(k):
            result.append(freqs[_][0])
        
        return result
```

- 아이디어
    - collections.Counter, most_common() 이용

- 참고
    - https://www.daleseo.com/python-collections-counter/