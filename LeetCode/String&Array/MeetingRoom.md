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

  

  **음수 또는 0이면 객체의 자리가 그대로 유지**되며, **양수인 경우에는 두 객체의 자리가 변경**된다.