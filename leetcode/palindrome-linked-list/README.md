> https://leetcode.com/problems/palindrome-linked-list


```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        
        ListNode a = head;
        while (a != null) {
            stk.push(a);
            a = a.next;
        }
        
        ListNode target = head;
        
        while(!stk.isEmpty()) {
            ListNode b = stk.pop();
            if (target.val != b.val) {
                return false;
            }
            target = target.next;
        }
        
        return true;
    }
}

```

- 아이디어
    - Stack 이용

- 제한사항
    - 딱히 없는듯.
    

- 기타
    - Could you do it in O(n) time and O(1) space?
    - O(1) 에 어떻게 할 수 있을까..
    

---

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        q = []
        # q = collections.deque()
        node = head
        
        while node is not None:
            q.append(node.val)
            node = node.next
            
        while len(q) > 1:
            if q.pop(0) != q.pop():
            #  if q.popleft() != q.pop():
                return False
        return True
        
        
        
        
```

- 이해
    - 팰린드롬? 거꾸로 읽어도 똑같은 문장.
    - 리스트가 주어지고 거꾸로 해도 같은 리스트 인지 판단하는 것.

- 아이디어
    - 리스트 활용
    - `q.pop(0)` 를 통해서 리스트의 맨 처음 요소를 가져오고, `q.pop()` 을 통해서 큐의 마지막 요소를 가져옴.
    - 이 부분을 최적화 하기 위해서 `collections.deque()` 를 이용하는 방법도 있을 듯.

