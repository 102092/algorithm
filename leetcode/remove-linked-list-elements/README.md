> https://leetcode.com/problems/remove-linked-list-elements/


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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        
        Queue<ListNode> queue = new LinkedList<>();
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                curr = curr.next;
                continue;
            }
            
            queue.add(curr);
            curr = curr.next;
        }
        
        if (queue.size() == 0) {
            return null;
        }
        
        curr = queue.peek();
        ListNode first = curr;
        queue.remove();
        
        for (ListNode q : queue) {
            curr.next = q;
            curr = curr.next;
        }
        
        curr.next = null;
        
        return first;
        
    }
}

```

- 아이디어
    - Queue 이용
    - 재귀 사용해서 풀 수 있을 듯 하기도 함.

- 제한사항
    - head 가 null로 들어올 base condition만 생각하면 될듯.

- 기타
    - 
    
