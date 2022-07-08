```python
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height or len(height) == 1:
            return 0
        
        volume = 0
        left, right = 0, len(height) - 1 # two pointer
        
        left_max, right_max = height[left], height[right] 
        
        while left < right:
            left_max, right_max = max(height[left], left_max), max(height[right], right_max)
            
            
            if left_max <= right_max:
                # print('left', left)
                # print('left_max', left_max)
                # print('height[left]', height[left])
                volume += left_max - height[left]
                left += 1
            else:
                # print('right', right)
                # print('height[right]', height[right])
                # print('right_max', right_max)
                volume += right_max - height[right]
                right -= 1
            # print('volume', volume)
            # print('\n')
        return volume
```


- 제한사항
    - height의 길이가 1이상 나옴. 그때는 0을 리턴해야할듯
- 아이디어
    - 투포인터
    - 최대 높이까지, 각각 좌우 기둥의 최대 높이 left_max, right_max가 현재 높이 (e.g height[left], height[right]) 차이만큼을 물 높이(volume) 에 더함
    - 결과적으로 포인터는 최대 높이에서 만나게 됨.

- 시간복잡도
    - O(N)
