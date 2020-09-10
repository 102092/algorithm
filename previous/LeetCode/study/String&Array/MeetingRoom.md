## 강의풀이

```java
package main;

import java.io.*;
import java.util.*;


class Interval{
    int start;
    int end;

    Interval(){
        this.start = 0;
        this.end = 0;
    }

    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}
public class MeetingRoom {   
     public static void main(String[] args) throws IOException {
        MeetingRoom a = new MeetingRoom();
        
        Interval in1 = new Interval(7,10);
        Interval in2 = new Interval(2,4);        

        Interval[] intervals = {in1, in2};
        System.out.println(a.solve(intervals));
        
    
    }

    public boolean solve(Interval[] intervals){
        //null check
        if(intervals == null) return false;
        Arrays.sort(intervals, Comp);
        
        //비교
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i-1].end > intervals[i].start) return false;
            
        }
        return true;

    }
    Comparator<Interval> Comp = new Comparator<Interval>(){
    
        @Override
        public int compare(Interval o1, Interval o2) {
            //오름차순 5, 4? 자리를 바꿔야지 양수를 리턴해야함.
            return o1.start - o2.start;
        }
    };

    public void print(Interval[] intervals){
        for (int i = 0; i < intervals.length; i++) {
            Interval in = intervals[i];
            System.out.println(in.start+" "+in.end);            
        }
    }    
}
```







## 나의풀이



## 필요개념

```java
   Comparator<Interval> Comp = new Comparator<Interval>(){
    
        @Override
        public int compare(Interval o1, Interval o2) {
            //오름차순
            return o1.start - o2.start;
            
            //내림차순
            return o2.start - o1.start;
        }
    };

```

- [참고](https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html)



### Interface Comparator

- 기본정렬기준과 다르게 사용하고 싶을 때 사용

- 오름차순을 정렬을 **내림차순으로 바꾸고 싶을 때 많이 사용**한다.

- compare() 메서드 작성법
  첫 번째 파라미터로 넘어온 객체 < 두 번째 파라미터로 넘어온 객체: **음수** 리턴
  첫 번째 파라미터로 넘어온 객체 == 두 번째 파라미터로 넘어온 객체: **0** 리턴
  첫 번째 파라미터로 넘어온 객체 > 두 번째 파라미터로 넘어온 객체: **양수** 리턴

  

  **!!음수 또는 0이면 객체의 자리가 그대로 유지**되며, **양수인 경우에는 두 객체의 자리가 변경**된다.

### 객체 정렬

- 두가지 방법이 있는데
  1. `Comparable` (interface)
  2. `Comparator` (interface)
     - 둘 다 인터페이스임.

#### comparable

- 기본적으로 적용되는 정렬 기준이 되는 인터페이스. 

  - Integer, Double 클래스는 오름차순,
  - String 클래스는 사전순으로 정렬됨.

- 구현방법

  - `comparable` interface를 `implement` 한 후, `compareTo()` 메서드를 오버라이드해서 r구현함.

- 사용방법

  - `Array.sort(arry)`

  - `Collection.sort(list)` 

    - 둘 차이?

    1. Array.sort()
       - Object Array ( byte[], char[], double[], int[], Object[], T[] )에서는 **TimSort(Merge Sort + Insertion Sort)**를 사용
       - 새로 정의한 클래스에 대한 배열,  Primitive Array에서는 **Dual Pivot QuickSort(Quick Sort + Insertion Sort)**를 사용
       - 즉 배열 정렬 방법에서 차이가 있음.
    2. Collection.sort()
       - ArrayList, LinkedList, Vector 등 , 내부적으로 Arrays.sort()를 사용
         

#### comparator

- `comparable` 의 기본정렬기준과 다르게 사용하고 싶을 때.
  - 주로 익명클래스로 사용.
  - **내림차순 정렬**을 할 때 많이 사용.
- 구현방법
  - Comparator interface를 implements 후 compare() 메서드를 오버라이드한 myComparator class를 작성
- 사용방법
  - Arrays.sort(array, myComparator)
  - Collections.sort(list, myComparator)
  - Arrays.sort(), Collections.sort() 메서드는 **두 번째 인자**로 `Comparator interface`를 받을 수 있음
    - 우선 순위 큐(PriorityQueue) 생성자의 두 번째 인자로 `Comparator interface`를 받을 수 있음
    - `PriorityQueue(int initialCapacity, Comparator<? super E> comparator)`
      - 지정된 `comparator` 방법에 따라서, <u>우선순위를 할당함!</u>

