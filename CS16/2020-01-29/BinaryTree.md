## 참고

- [https://www.inflearn.com/course/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%95%EC%A2%8C/lecture/4092](https://www.inflearn.com/course/알고리즘-강좌/lecture/4092)
- https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
- https://www.acmicpc.net/problem/1991



## 목표

- 이진 트리가 무엇인지 학습한다.
- 이진 검색트리가 무엇인지 학습한다.
-  트리의 순회에 대해 학습한다.
-  힙이 무엇인지와 힙 정렬에 대해 학습한다.
-  [백준 1991 풀기](#4.-백준-1991)



## 1. 트리와 이진트리

- 트리 : 계층적으로 내려가는 것을 일컫는 말.
- 트리를 구성하는 요소 하나하나를 node, 대장 node를 root node, node와 node와 연결하는 것을 link라 함
- 부모 - 자식 관계
  - 굉장히 상대적인 관계
- 형제 관계
  - 동일한 부모 노드를 가진 노드들.
- 루트 노드는 부모 노드가 없음.
- leaf 노드 : 자식이 없는 노드를 일컫는 말.
  - leaf 노드가 아닌 노드를 internal node라 함.
- sub tree, 부 트리 : 전체 트리의 일부분인 또다른 트리모양을 일컫는 말
- Level 
  - root는 level 1 (or level 0라고도 함).
- 트리의 기본적인 성질
  - 노드의 갯수가 N개면, 링크의 갯수는 N-1개



### 이진트리

- binary tree

- 각각의 노드가 **최대 2명의 자식**(2 or 1 or 0)을 가지고 있는 트리를 일컫는 말

- 자식 노드들은 부모의 왼쪽 자식인지 오른쪽 자식인지 정하게 되어있음 (엄격)

  - 만약 같은 자식을 가지는데, 순서가 다르다면, 다른 이진트리라 말할 수 있다.

- Full Binary Tree VS Complete Binary Tree

  ![](https://sungjk.github.io/images/2016/10/07/full-and-complete-binary-tree.png)
  - **heap은** complete binary tree여야 함.
  - full : 높이가 h라면, 노드의 갯수는 $2^h-1$ 개의 노드를 가짐. ($높이 : 3$   $노드갯수 : 2^3-1$ == 7 )
  - full or complete 이진트리가 노드 갯수가 N개라면 높이는 O(logN)

- 이진 트리 표현

  - 보통 `LinkedList`



### 이진트리의 순회 

- traversal
- 순회 : 모든 노드를 방문하는 일
  - **중순위 <u>in</u>order**
    - `루트가 중간에 있음.`
  - **선순위 <u>pre</u>order**
    - `루트가 젤처음`
  - **후순위 <u>post</u>order**
    - `루트가 마지막`
  - *레벨오더 level-order*

- 시간복잡도 $O(n)$



#### Inorder

- 트리 전체를 세부분으로 나눠서 생각함.

  1. 루트 노드 $r$
  2. 루트의 왼쪽 부트리 $T_L$
  3. 루트의 오른쪽 부트리 $T_R$

  

1. $T_L$ 을 inorder로 순회

2. $r$ 을 방문하고

3. $T_R$ 을 inorder로 순회

- 왼쪽, 위, 오른쪽

- recursive
  - 왜? 전체를 순회하기 위해서, 자기보다 작은 부트리를 Inorder로 순회하기 때문에
  - 작은 inorder을 통해 큰 inorder를 달성한다.

![](https://i1.wp.com/www.techiedelight.com/wp-content/uploads/Inorder-Traversal.png?zoom=2.625&resize=344%2C437&ssl=1)



#### postorder

1. $T_L$ 을 postorder 순회
2. $T_R$ 을 postorder 순회
3. $r$ 을 방문

![](https://i0.wp.com/www.techiedelight.com/wp-content/uploads/Postorder-Traversal.png?zoom=2.625&resize=355%2C436&ssl=1)

#### preorder

1. $r$ 을 방문
2. $T_L$ 을 preorder 순회
3. $T_R$ 을 preorder 순회

![](https://i0.wp.com/www.techiedelight.com/wp-content/uploads/Preorder-Traversal.png?zoom=2.625&resize=343%2C440&ssl=1)

#### level - order

- 위의 3가지 방법과는 전혀 다른 방향.
- 이진트리를 Level 순으로 방문한다.
- 동일 레벨에서는 **왼쪽에서 오른쪽**으로
- `Queue`를 이용해서

![](data:image/png;base64,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)



## 2. 이진 검색 트리

- Binary Search Tree

- 트리?
  - 보관하고 검색하는 자료 자체가, 계층적인 구조를 가지고 있을 때 사용함
  - 예) 조직도, 가계도

- 검색 트리?

  - 일종의 컨테이너, 집합

  - 여러개의 데이터를 저장하고 있는데, 이러한 데이터들이 고정되어있지 않고, **추가, 삭제, 검색** 이 *빈번*하게 일어남.

  - 이러한 세가지 연산을 효율적으로 지원하기 위함.

  - Dynamic set, Search Structure

  - 저장 옵션이 몇가지 있는데,

    - 정렬을 할 수도 있고, 하지 않을 수도 있고

    

  1. 배열에 정렬하지 않고 저장했다면, 
     - Search를 위해서는 O(N)
     - Insert를 위해서는 O(1) or O(N) --> 배열 복사를 위함.
     - Delete 를 위해서는 O(1) -- (해당 노드를 찾는 시간 제외, 지우는 작업만을 위한 시간복잡도)

  2. 배열에 정렬하였다면,
     - Search를 위해서는 O(logN)
     - nsert를 위해서는 O(N)
     - Delete 를 위해서는 O(N) 

  3. 연결리스트에 정렬하지 않고 저장했다면
     - Search를 위해서는 O(N)
     - Insert를 위해서는 O(1)
     - Delete 를 위해서는 O(1) -- (해당 노드를 찾는 시간 제외, 지우는 작업만을 위한 시간복잡도)

  4. 연결리스트에 정렬하고 저장했다면,
     - Search를 위해서는 O(N)
     - Insert를 위해서는 O(N)
     - Delete 를 위해서는 O(1)  -- (해당 노드를 찾는 시간 제외, 지우는 작업만을 위한 시간복잡도)

- 정리해보자면, 4가지 방법중 어느 하나를 선택하더라도 *Insert, Search, Delete*중 적어도 하나는 시간복잡도가 **O(n)** 

- 어떻게 하면, 셋다 효율적으로 할 수 없을까? O(n) 보다 적게 걸리게?
  - 이진 탐색 트리, 레드-블랙 트리, AVL-트리
  - 해쉬 테이블..



- 검색트리는 Dynamic set을 트리 형태로 구현한것
  - 즉 계층적인 데이터로 부터 비롯된 것이 아니라,
  - 검색, 삭제, 추가를 효율적으로 구현하기 위해서 트리 형태로 만든 것.
  - 일반적으로 연산의 시간복잡도는 tree의 높이에 **비례**한다



#### BST

- Binary Search Tree

- 기본적으로 **이진 트리**

  - 각각의 노드가 최대 2명 자식을 가지고 있고, 누가 왼쪽 자식인지 오른쪽 자식인지 명시되어있음.
  - 각 노드마다 하나의 데이터를 저장함.

- 그러면서, 아래 조건을 만족

  - 각 노드 v에 대해서, 그 노드의 **왼쪽 부트리**에 있는 키들은 key[v]보다 **작거나 같고**, *오른쪽 부트리*에 있는 값은 *크거나 같다*.

  ![](data:image/png;base64,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)

- $cf$  heap과 헷갈릴수 있음

  - 그렇지만 heap은 complete binary tree 이어야만 함. 이진트리는 그것을 포함하는 개념이구

    - 왼쪽 부터 채워져 있어야함.

    ```
                   18
               /       \  
             15         30  
            /  \        /  \
          40    50    100   40
    
    
                   18
               /       \  
             15         30  
            /  \        /  \
          40    50    100   40
         /  \   /
        8   7  9 
    ```

    - 이런 모양이 complete binary tree

    - heap?

      - Min Heap or Max Heap
      - Min Heap은 key root가 다른 노드들과 비교했을 때 반드시 최소여야 함
      - Max Heap은 key root가 다른 노드들과 비교했을 때 반드시 최대여야 함.
      - 회귀적으로 봤을 때도 성립해야하고

      ![](https://www.geeksforgeeks.org/wp-content/uploads/MinHeapAndMaxHeap.png)

##### SEARCH

1. 먼저 루트 노드로 접근해서, 해당 값인지 확인
2. 아니라면, **자신이 찾는 값**이 *루트보다 **작으면** 왼쪽 부트리에 있을 것*이고, ***크다면*** *오른쪽 서브트리에 있을 것* 이다(이진 검색 트리의 특징을 이용)

3. 위의 판단에 따라 회귀적으로 검색을 이어간다.

- 시간복잡도 $O(N)$

- 최소값 찾기
  - 자신의 왼쪽 자식이 없어야 겠고,
  - 누군가의 오른쪽 부트리이지 않아야함.
  - 위 2가지 조건을 만족하는 노드는, 루트에서 왼쪽으로 쭉 내려가서 더 이상 내려갈 수 없는 노드임.
  - 시간복잡도 $O(h)$  h : tree height
- 최대값 찾기
  - 루트에서부터 오른쪽으로 쭉 내려가서 더 이상 내려갈 수 없을 때 노드.
  - 시간복잡도 $O(h)$  h : tree height

- successor

  - 나보다 크면서 가장 작은 값
  - 모든 키들이 서로 다르다고 가정

  ![](https://i2.wp.com/algorithms.tutorialhorizon.com/files/2014/09/InOrder-Successor-example.png)

  - successor 가 항상 존재하지는 않는다.
  - 3가지 경우가 있는데,
    1. 노드 x의 오른쪽 부트리가 존재한다면, 오른쪽 부트리의 최소값.
    2. 오른쪽 부트리가 없다면, 처음으로 왼쪽 링크를 타는 순간 만나는 노드.
    3. 1,2 번에 해당하지 않는다면, successor가 존재하지 않는다 == 최대값이다.
  - 시간복잡도 $O(h)$

- presuccessor
  - successor와 대칭적인 관계
  - 나보다 작으면서 가장 큰 값.



##### INSERT

- 새로운 노드를 이진검색트리에 추가하는 것.
- 기존의 노드들은 전혀 변경하지 않는다.
- 2개의 포인터(x,y)를 사용함.
  - 왜? 내가 찾은 위치(y)를 보존하기 위해서.
  - x == null이면, y에 저장하는데, 저장하고 싶은 값이 y보다 크면 오른쪽 에, 작으면 y 왼쪽에

![](https://i2.wp.com/www.techiedelight.com/wp-content/uploads/Insert-into-BST.png?zoom=2.625&resize=368%2C329&ssl=1)

- 시간복잡도 $O(h)$



##### DELETE

- 일반적으로 DELETE는 SEARCH작업을 포함하고 있음.

1. 자식노드가 없으면?
   - 그냥 삭제해버림.

2. 자식노드가 1개 있는 경우
   - 연결리스트 중간에 노드 삭제하고 서로 연결해주는 형식
3. 자식 노드가 2개 있는 경우
   - 트리의 기본적 구조 자체가 흐트러지기 때문에, 복잡해진다.
   - 해당 노드의 데이터만 삭제하고, 다른 노드의 데이터를 가져와서 복사하는 형식
   - 다른 노드는 어떤?
     - successor or presuccessor
     - successor ? 자기보다 크면서, 다른 후보군 중에서 작은 노드
     - presuccessor ? 자기보다 작으면서, 다른 후보군 중에서 가장 큰 노드

- 시간복잡도 $O(h)$

- [참고](https://www.quora.com/What-is-the-best-deletion-algorithm-for-a-binary-search-tree-without-using-an-additional-parent-node)



## 3. 힙, 힙정렬

- Heap Sort 
  - 최악 $O(nlogn)$ == Merger Sort(추가 배열 필요)
  - heap sort 는 추가 배열 필요 없음, *즉 추가적인 메모리 없어도 됨.*
  - binary heap 자료구조를 이용하여,



#### heap

- Complete binary tree면서,
  - 왼쪽 노드들은 반드시 채워저야 있어야 하지만, 오른쪽 노드들은 비어져 있을 수도 있음.
  - Full binary tree이면, Complete binary tree이다.
- *heap property* 를 만족해야 *heap* 이라 함.
  - *Max heap* : 부모는 자식보다 크거나 같다.
  - *Min heap* : 부모는 자식보다 작거나 같다.

- 동일한 데이터를 가진 서로 다른 힙 이 있을 수 있음.
- <u>힙은 일차원 배열로 표현할 수 있음.</u>
  - i 노드의 왼쪽 노드는 2i , 오른쪽 노드는 2i -1;
  - 어떤 노드 j의 부모 노드는 j/2



#### heap sort

- heap을 이용해서 sorting 하는 것.

- MAX-HEAPIFY

  - 전제조건 : 트리모양이 complete binary tree
  - 왼쪽 서브 트리 자체로 봤을 때, heap이고,
  - 오른쪽 서브트리 자체만 봤을 때 heap일때,
  - 유일하게 root node만이 heap property를 만족하지 않을 때,
  - heap을 만족하도록 하는 행동을 일컫는 말.
  - 어떻게 할까?
  - root node의 값을 아래로 내려 보내야 하고, 어떤 값이 위로 올라오겠지.

- recursion

  ```java
  MAX-HEAPIFY(Heap, i){
    if there is no child of Heap[i]
      return;
    k <- index of the biggest child of i;
    if Heap[i] >= Heap[k]
      return;
    exchange Heap[i] and Heap[k];
    MAX-HEAPIFY(Heap, k)
  }
  ```

- iterative 

  ```java
  MAX-HEAPIFY(Heap, i){
    while Heap[i] has a child do
      k <- index of the biggest child of i;
    	if Heap[i] >= Heap[k]
        return;
    	exchange Heap[i] and Heap[k];
    	i = k;
    end
  }
  ```

- 시간복잡도 $O(h)$

  - Complete binary tree이기에, h = O(logn)



- 어떻게 **힙소트**를 하는가?

  1. 주어진 데이터를 heap(MAX-Heap)의 형태로 만든다.
  2. 힙에서 마지막 값과, 루트의 값을 자리를 바꾼다 --> 배열의 맨 마지막 값은 이제 생각하지 않아도됨. 왜? 가장 큰 값이 제 자리를 찾아 갔으므로,
     - heap의 크기가 하나 줄은 것으로 간주함.
  3. `MAX-HEAPIFY(1)`를 실행, 루트에 대해 
  4. 2,3번 반복

  - 회귀를 이용, MAX-HEAPIFY 형태로 만들어서, 

- 시간복잡도 $O(nlog_2n)$



#### 우선 순위 큐

- priority queue

- queue FIFO, First in First out
- INSERT(), EXTRACT_MAX()를 지원.__ 최대 우선순위 큐
  - 우선 순위를 어떻게 매길 것인가?
  - 데이터가 들어간 순서?
  - 혹은 숫자면 큰 값이 우선 순위가 높을까? 작은 값이 우선 순위가 높을 까?

- MAX-HEAP을 이용하여 우선 순위 큐 구현.

  - INSERT()

  ```java
  MAX-HEAP-INSERT(heap, key){
    heap_size = heap_size +1;
    heap(heap_size) = key;
    i = heap_size;
    while(i > 1 and heap[PARENT(i)] < heap[i]){
      exchange heap[i] and heap[PARENT(i)];
      i = PARENT(i);
    }
  }
  ```

  - 시간복잡도 $O(log_2n)$
    - 왜? O(h), h는 트리 높이.
    - heap은 complete binary tree이므로, 노드의 갯수를 n개라 했을 때, 높이는 logn
  - EXTRACT_MAX()
    - 최대값은 루트인 것은 자명.
    - 다만 어떤 값이 대처할 것인가?
      - 마지막 노드로.

  ```java 
  HEAP-EXTRACT-MAX(A){
    if heap-size[A] < 1
      then error "heap underflow";
    max <- A[1];
    A[1] <- A[heap-size[A]];
    heap-size[A] <- heap-size[A] -1;
    MAX-HEAPIFY(A,1);
    return max;
  }
  ```

  - 시간복잡도 $O(log_2n)$



## 4. 백준 1991

```java
package algorithm.jan29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TreeTraversal {
    public static class Node{
        String key;
        Node left, right;

        public Node(String item){
            key = item;
            left = right = null;
        }
    }

    public static class BinaryTree{
        Node root;

        public BinaryTree() {
            root = null;
        }

        void printPostOrder(Node node){
            if(node == null) return;

            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.key);
        }

        void printInOrder(Node node){
            if(node == null) return;

            printInOrder(node.left);
            System.out.print(node.key);
            printInOrder(node.right);
        }

        void printPreOrder(Node node){
            if(node == null) return;

            System.out.print(node.key);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Node> map = new HashMap<>();
        BinaryTree binaryTree = new BinaryTree();
        Node rootNode = null;

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count ; i++) {
            String[] nodes = br.readLine().split(" ");
            String root = nodes[0];
            String left = nodes[1];
            String right = nodes[2];

            map.put(root, map.getOrDefault(root, new Node(root)));
            Node base = map.get(root);

            if(i == 0){
                rootNode = base;
            }

            if(!left.equals(".")){
                Node leftNode = new Node(left);
                base.left = leftNode;
                map.put(left, leftNode);
            }

            if(!right.equals(".")){
                Node rightNode = new Node(right);
                base.right = rightNode;
                map.put(right, rightNode);
            }

        }
        binaryTree.printPreOrder(rootNode);
        System.out.println();
        binaryTree.printInOrder(rootNode);
        System.out.println();
        binaryTree.printPostOrder(rootNode);
    }
}
```

- Hash맵 자료구조를 이용
- Node, BinaryTree구조 직접 만듬 from geeks..

