```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head.next or left == right:
            return head
        
        # 1 2 3 4 5
        root = start = ListNode()
        root.next = head # 1
        
        for _ in range(left - 1):
            start = start.next # 1
        
        reverse = None
        curr = start.next 

        for _ in range(right - left + 1):
            next = curr.next 
            curr.next = reverse 
            reverse = curr 
            curr = next 
        
        start.next.next = curr # 1 -> 2 -> 5
        start.next = reverse # 1 -> 4 -> 3 -> 2 ->5
        
        return root.next
```

- 아이디어
    - left, right 범위내에 있는 노드들을 뒤짚은 다음에 그 결과를 reverse에 할당하고,
    - 그에 해당하지 않는 노드들을 이어줌.
