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
public class MeetingRoom2 {   
     public static void main(String[] args) throws IOException {
        MeetingRoom2 a = new MeetingRoom2();
        
        Interval in1 = new Interval(0,30);
        Interval in2 = new Interval(5,10);        
        Interval in3 = new Interval(15,20);        

        Interval[] intervals = {in1, in2, in3};
        System.out.println(a.solve(intervals));
        
    
    }

    public int solve(Interval[] intervals){

        //null check
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comp);

        Queue<Interval> pq = new PriorityQueue<Interval>(intervals.length, Comp2);
        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval temp = pq.poll(); 
            if(intervals[i].start < temp.end){// 5 10 과 0 30 비교
                pq.offer(intervals[i]);
            }
            pq.offer(temp);
            
        }
        
        return pq.size(); //2

    }
    Comparator<Interval> Comp = new Comparator<Interval>(){
    
        @Override
        public int compare(Interval o1, Interval o2) {
            //오름차순
            return o1.start - o2.start;
        }
    };

    Comparator<Interval> Comp2 = new Comparator<Interval>(){
    
        @Override
        public int compare(Interval o1, Interval o2) {
            //오름차순
            return o1.end - o2.end;
        }
    };    
}
```

## 나의풀이



## 필요개념

- 순서
  1. 소팅
  2. Priority queue 이용
  3. end <= start

- 회의실이 몇개 필요할 것인가? 문제의 핵심