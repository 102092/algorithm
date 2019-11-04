

## 강의풀이

```java
package app;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class MergeSortedList {
    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        MergeSortedList m = new MergeSortedList();
        ListNode result = m.mergedLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;

        }

    }

    private ListNode mergedLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(Comp);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead; // 복제하고

        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.offer(listNode);
            }

        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return newHead.next;
    }

    Comparator<ListNode> Comp = new Comparator<ListNode>() {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;// 오름차순 왜? 양수면 자리바꾼다.
        }

    };
}
```

## 나의풀이



## 필요개념

- Priority Queue를 이용.