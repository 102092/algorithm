> https://leetcode.com/problems/intersection-of-two-linked-lists/


```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        Set<ListNode> nodes = new HashSet<>();
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != null) {
            nodes.add(a);
            a = a.next;
        }
        
        while (b != null) {
            if (nodes.contains(b)) {
                return b;
            }
            b = b.next;
        }
        return null;        
        
    }
}

```

- 아이디어
    - 두 개의 링크드 리스트들이 있을 때, 서로 겹치는 지점이 있다면 그 지점을 반환하고 없다면 `null` 을 반환해야하는듯.
    - 싱글 링크드 리스트니, 하나의 노드를 모두 Set에 저장해두고, 다른 노드들을 돌면서, 확인하고 있으면 그 노드를 반환 없으면 null을 반환하는 형식이면 될듯.
    - 다만 that runs in O(m + n) time and use only O(1) memory 은 달성하지 못하는 데 방법 없을까?
    - [참고](https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!)

- 제한사항
    - Note that the linked lists must retain their original structure after the function returns.
        - 파라미터로 받는 headA, headB는 그대로 나둬야 하는듯.