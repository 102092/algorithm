> https://leetcode.com/problems/odd-even-linked-list/

## 나의풀이

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;

        ListNode even = head.next;
        ListNode odd =  head;
        ListNode evenHead = even;

        while(even != null && even.next != null) {
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

## 필요개념

- 짝수, 홀수를 Node를 가지고 있는 LinkedList를 만든 다음에 루프를 돌면서 각각 컨셉에 맞게 리스트 노드를 가지도록
-
