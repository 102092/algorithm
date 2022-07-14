> https://leetcode.com/problems/merge-two-sorted-lists/

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
    // list1 1 -> 2 -> 4
    // list2 1 -> 3 -> 4
    
    // 1 1 1 -> 1 -> 2 -> 3 -> 4 -> 4
    // 1 3 1 -> 2 -> 3 -> 4 -> 4
    // 2 3 2 -> 3 -> 4-> 4
    // 4 3 3 -> 4 -> 4
    // 4 4 4 -> 4
    // 4 null return 4
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        
        if (list1 == null) {
            return list2;
        }
        
        if (list2 == null) {
            return list1;
        }
        
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        
        
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
        
    }
}

```

- 아이디어
    - 재귀를 이용해보면 어떨까? 갯수가 최대가 50개인듯.

- 제한조건
    - 두 리스트 모두, 오름차순으로 정렬되어있음.
    - merged 된 링크드 리스트의 head를 리턴해야함
        - 그럼 코드레벨로 따로 기록해놔야하나?
        - 재귀를 이용하면 처음 스택이 반환 될 때 head를 반환할 것 같네


---

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if (not list1) or (list2 and (list1.val > list2.val)):
            list1, list2 = list2, list1
        
        if list1:
            list1.next = self.mergeTwoLists(list1.next, list2)
        
        return list1
```

- 아이디어
    - 재귀

- 이해
    - list1이 비어있거나 혹은 list2가 값이 있으면, list1 > list2의 값을 라면, 작은 값이 list1으로, 큰 값이 list2로 가게함.
    - 만약에 list1이 None이 아니라면 (존재한다면), `.next` 시에, list1.next와, list2의 값을 비교하도록 재귀호출로 넘김.
    - 