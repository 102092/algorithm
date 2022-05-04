> https://leetcode.com/problems/linked-list-cycle-ii/


```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // slow == fast 라는 건, 사이클 형태의 링크드 리스트라는 이야기이고..
            if (slow == fast) {
                
                slow = head;
                
                // 반환해야하는 건, tail node가 연결된 지점
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                // slow or fast 반환 가능
                return fast;
            }
        }
        return null;
    }
}

```

- 아이디어
    - two pointer

- 제한사항
    - `head` 가 null이 들어올 수 도 있음.
    - 혹은 `head.next` 가 null이면 사이클을 이룰 수 없으므로 -1를 리턴해야함

- 기타
    - 반환해야하는 건 조건에 맞는 게 없으면 null이거나, 혹은 tail node와 연결된 노드를 반환하면 되는듯