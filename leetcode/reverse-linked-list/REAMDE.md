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

