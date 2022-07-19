> https://leetcode.com/problems/add-two-numbers/

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
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        while(l1 != null){
            st1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        while(!st1.isEmpty()) {
            sb1.append(st1.pop());
        }
        
        while(!st2.isEmpty()) {
             sb2.append(st2.pop());
        }
        
        BigInteger i1 = new BigInteger(sb1.toString());
        BigInteger i2 = new BigInteger(sb2.toString());
        int[] digits = Stream.of(String.valueOf(i1.add(i2).toString()).split("")).mapToInt(Integer::parseInt).toArray();
        
        ListNode head = null;
        ListNode curr = null;
        
        for(int i = digits.length -1; i >= 0; i--) {
            if (head == null) {
                head = new ListNode(digits[i]);
                curr = head;
                continue;
            }
            
            curr.next = new ListNode(digits[i]);
            curr = curr.next;
        }
        
        return head;
    }
}

```

- 아이디어
    - 캐스팅을 많이 해야하지만 string -> integer -> int[] -> new ListNode를 만들고 연결해주는 방식
        - string -> integer에서 해당 타입의 범위를 넘어간 계산을 하여서, (int는 10자리) 

- 제한조건
    - 100자리대 수까지 나올 수 있음.
    - 거꾸로 정렬되었을 때 0으로 시작하는 경우의 수는 없다.


- 기타
    - [참고](https://docs.oracle.com/javase/6/docs/api/java/math/BigInteger.html)



---

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        root = head = ListNode();
        
        carry = 0
        while l1 or l2 or carry:
            sum = 0 
            
            
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next
            
            carry, val = divmod(sum + carry, 10)
            head.next = ListNode(val)
            head = head.next
        
        return root.next
```

- 아이디어
    - 전가산기
    - 

- 이해
    - `divmod()` 몫과 나머지로 구성된 튜플을 리턴, (a // b, a % b) 와 같은 결과.
    - 즉 `divmod(sum + carry, 10)` 는 sum + carry을 10으로 나눈 것의 몫이 carry 에, 그 나머지가 val에 할당됨.
    - 굳이 l1, l2를 뒤집지 않아도 root 라고 미리할당해놓으면 쌓어진 리스트를 반환할 수 있음.