```java
class Solution {
    // 홀수에 해당하는 리스트노드들을 제거한다음에 even 노드 마지막에 붙어야하는듯.
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode even = head.next;
        ListNode odd = head;
        
        // even list의 head
        ListNode evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
        
    }
}

```

- 아이디어
    - 2 pointer (odd, even)

- 제한사항
    - head == null, base condition
    
- 기타
    - odd pointer와 even pointer가 움직이는 방식을 직접 그려보면 조금 더 이해가 잘 되는 것 같음.

---

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # head can be null
        if head is None:
            return None
        
        # odd, even link list
        odd = head
        even = head.next
        even_head = head.next
        
        # while even and even.next:
        while odd and odd.next and odd.next.next:
            odd.next = odd.next.next
            odd = odd.next
            even.next = even.next.next
            even = even.next

            # 다중할당 이용
            # odd.next, even.next = odd.next.next, even.next.next
            # odd, even = odd.next, even.next
        
        odd.next = even_head
        # head is node 1
        return head
```

- 이해
    - 홀수 노드들 다음에 짝수 노드들이 오게 되어야함.
- 아이디어
    - 홀 수 노드들, 짝수노드들을 구성한 다음에, 홀수 노드의 마지막에 짝수노드의 첫번째가 오게 하면 될듯.