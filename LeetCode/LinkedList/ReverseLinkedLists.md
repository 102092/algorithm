

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

public class ReverseLinkedLists {
    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        // printNode(l1);
        ListNode result = reverseList(l1);
        printNode(result);

    }

    private static ListNode reverseList(ListNode current) {
        ListNode prev = null; //이전
        ListNode next = null; //그다음

        while (current != null) {
            next = current.next; // 2를 저장해두고
            current.next = prev; // 1.next 는 null로 설정하고
            prev = current; // prev는 1로 설정하고
            current = next; // current값을 2로 재설정

        }
        return prev;
    }

    private static void printNode(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
    }

}
```

## 나의풀이



## 필요개념

```java
next = current.next; // 2를 저장해두고
current.next = prev; // 1.next 는 null로 설정하고
prev = current; // prev는 1로 설정하고
current = next; // current값을 2로 재설정
```

- 이부분이 핵심.
- 큰범위에서 설명하자면, 1.next = null 설정하고,
  - 2.next = 1.next;
  - 3.next = 2.next;



- 자세히 풀어써보자

```java
//1 cur = 1
next = 2-3 (1.next에 해당하는);
1.next = null (1--null 연결됨);
prev = 1-null;
cur = 2-3;

//2 cur = 2-3;
next = 3 - null; (2.next에 해당하는);
2.next = 1-null; ( 2-1-null 연결);
prev = 2-1-null;
cur = 3 - null;

//3 cur =3;
next = null;
3.next = 2-1-null; (3-2-1-null 연결 완성!);
prev = 3-2-1-null;
cur = null; //while문 끝남.
```

