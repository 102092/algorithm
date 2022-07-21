```python
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        
        cur = head
        
        while cur and cur.next:
            cur.val, cur.next.val = cur.next.val, cur.val
            cur = cur.next.next
        
        return head
        
```
- 제한사항
    - head가 null일 수 있음.
    - You must solve the problem without modifying the values in the list's nodes ()
- 아이디어
    - 값만 교환

```python

class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        root = prev = ListNode()
        prev.next = head 
    
        
        # 1 -> 2 -> 3 -> 4 -> 5 -> 6
        # head head.next
        # 2 -> 1 -> 3 -> 4 -> 5 -> 6
        #    prev.next head head.next
        while head and head.next:
            temp = head.next  
            head.next = temp.next
            temp.next = head  
            
            
            prev.next = temp # 1 -> 4 -> 3 -> 5 -> 6
            head = head.next
            prev = prev.next.next
        return root.next
            
        
```
- 아이디어
    - while 문 사용
    - `prev` 노드를 기록해두는 것이 핵심


```python
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        result = head.next
        print(result)
        head.next = self.swapPairs(result.next)
        result.next = head
        
        return result
            
        
```

- 아이디어
    - recursive