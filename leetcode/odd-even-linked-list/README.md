> https://leetcode.com/problems/odd-even-linked-list/


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
