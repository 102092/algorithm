```python
import sys

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_price = sys.maxsize

        for price in prices:
            min_price = min(min_price, price)
            
            # 현재가 가지고 있는 profit과 계산한 profit(price - min price) 의 최대값
            profit = max(profit, price - min_price)

        return profit
```


- 이해
    - 좌에서 우로                                    
    - 단 한번 거래
    - 최대 이익을 반환해야함 (6 - 1 = 5), 1에서 사서, 6에서 팔면 5인데 이게 최대 이익임.

- 아이디어
    - 리스트에서의 최솟값과, 최대 이익을 기억해야할듯.
- 제한사항
    - prices.length >= 1, 빈 배열이 들어올 경우는 없음
    - price의 최대값은 10^4 (math.pow(10,4))

- 시간복잡도
    - O(N)

- 기타
    - 최솟값, 최대값을 지정해야할 때는 시스템에서 비롯된 설정을 하는게 좋음.