

## 강의풀이

```java

package app;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class AddTwoNumber {
    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = solve(l1, l2);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    private static ListNode solve(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        // 직접 위의 변수들을 사용해도 되지만, 이걸 카피해서 사용하는 것이 정석.
        ListNode p1 = l1, p2 = l2, p3 = newHead;
        int carry = 0; 

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10; // 몫을 넘긴다.
        }
        if (carry == 1)
            p3.next = new ListNode(1);
        return newHead.next;
    }
}
```

## 나의풀이



## 필요개념

- ListNode next type에 대해

  ```java
  class ListNode {
      int val;
      ListNode next;
  
      ListNode(int x) {
          this.val = x;
      }
  }
  ```

  - ListNode에 대해 어느정도 정의해놓는 것이 핵심