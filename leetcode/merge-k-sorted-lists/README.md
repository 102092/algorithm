```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # if lists = []
        if not lists:
            return None
        
        # if lists = [[]]
        if len(lists) == 1 and not lists[0]:
            return None
        
        root = result = ListNode()
        heap = []

        # push root node of list 
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i, lists[i]))
            
        #  print(len(heap)) == 3
        while heap:
            node = heapq.heappop(heap)
            index = node[1]
            result.next = node[2]
            
            result = result.next
            if result.next:
                heapq.heappush(heap, (result.next.val, index, result.next))
            
        return root.next
                
        
        
```


- heapq
    - **min heap**, 저장되는 원소는 항상 정렬되어 저장되고, 인덱스 0의 값에는 가장 최소값이 저장되는 자료구조를 의미.
    - 생성 -> `heap = []` , 리스트 생성하는 것과 같이
    - 원소 추가 -> `heapq.heappush(heap, 4)`, `heappush` 함수 이용
    - 원소 삭제 -> `heapq.heappop(heap)`

- 참고
    - https://www.daleseo.com/python-heapq/