

## 강의풀이

```java
package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval{
    int start;
    int end;

    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}
public class MergeInterval {
    public static void main(String[] args) throws Exception {
        //input 생성
        Interval in = new Interval(1, 3);
        Interval in1 = new Interval(2, 6);
        Interval in2 = new Interval(8, 10);
        Interval in3 = new Interval(15, 18);
        MergeInterval a = new MergeInterval();
        List<Interval> list = new ArrayList<Interval>();
        list.add(in);
        list.add(in1);
        list.add(in3);
        list.add(in2);

        a.solve(list);
        
    }
    private List<Interval> solve(List<Interval> list) {
        List<Interval> result = new ArrayList<>();
        if(list == null || list.size() ==0) return result; //아무것도 안들었음을 던진다.
        print(list);
        
        Collections.sort(list, comp);
        System.out.println("====after=====");
        print(list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start <list.get(i-1).end) {
                Interval tmp = new Interval(list.get(i-1).start, list.get(i).end);
                result.add(tmp);
                
            }else{
                result.add(list.get(i));
            }
            
        }
        System.out.println("====sovle====");
        print(result);

        
        
        return result;
    }
    Comparator<Interval> comp = new Comparator<Interval>() {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start; //오름차순.
        }
    };

    private void print(List<Interval> list) {
        if(list !=null){
            for (Interval in : list) {
                if(in !=null){
                    System.out.println(in.start+" "+in.end);
                }
                
            }
        }
    }
}
```



## 나의풀이



## 필요개념

- for문, **Comparator**가 필요하겠다.처음 느꼈음.
  - 추가적으로 클래스화, 리스트화, Map, Array 를 이용하는 문제라는 점은 몰랐당.

- 현재 start < 이전 end 라면
  - 새롭게 1,6 배열을 만들어야함.

