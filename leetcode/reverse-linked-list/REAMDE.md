> https://leetcode.com/problems/reverse-linked-list/


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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
    
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            // 2
            ListNode temp = curr.next;
            
            // 1 -> null, 2 -> 1, 3 -> 2
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        
        return prev;
        
    }
}

```

- 아이디어
    - Iterator
    - 재귀 혹은 Stack을 통해서도 풀 수 있을 것 같은데 생각해보면 좋을듯

- 제한사항
    - head 가 null로 들어올 base condition만 생각하면 될듯.

- 기타
    - [Stack 풀이방법](https://leetcode.com/submissions/detail/697756366/)


--- 

```python
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        
        def reverse(node: ListNode, prev: ListNode = None):
            if not node:
                return prev
        
            next, node.next = node.next, prev
            return reverse(next, node)
        return reverse(head)
             
```

- recursive

```python
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node, prev = head, None
        
        while node:
            next, node.next = node.next, prev
            prev, node = node, next
        
        return prev
        
```

- iterator

```python
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        
        stk = [] 
        
        while head:
            stk.append(head)
            head = head.next

        temp = stk.pop()
        prev = temp
        
        while stk:
            temp.next = stk.pop();
            temp = temp.next
        
        temp.next = None
        return prev
            
```

- using stack
    - https://www.geeksforgeeks.org/program-to-reverse-a-linked-list-using-stack/
- 다중 할당 조심
