## 강의풀이

```java
package main;

import java.io.*;
import java.util.*;


public class KCPTO {
    public static void main(String[] args) throws IOException { 
        KCPTO a = new KCPTO();
        // int[][] points = {
        //                  {1,3},
        //                  {-2,2}
        //                  };
        // int k = 1;

        int[][] points = {{3,3},{5,-1},{2,-4}};
        int k = 2;

        int[][] result = a.solve(points, k);
        a.print(result);
    }

    private void print(int[][] result) {       
        for (int[] var : result) {
            System.out.println(Arrays.toString(var));
            //배열을 출력할 떄 Arrays.toString 이용
            
        }

    
    }

    private int[][] solve(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);
        //2차원 배열 0행 2열
        int[][] result = new int[k][2];
        int index = 0;

        for (int[] p : points) {            
            queue.offer(p); //{3,3} {2,-4} {5,-1} 순으로 담겨있을 것
            
        }
        while (index < k) { //index 0, 1만 들어갈것 그럼 {3,3} , {2,-4} 만
            result[index] = queue.poll();
            index++;
        }
        return result;
    }
    Comparator<int[]> Comp = new Comparator<int[]>(){
    
        @Override
        public int compare(int[] o1, int[] o2) {     
            //o1에 대한 오름차순   
            return (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0] + o2[1]*o2[1]);
        }
    };
}
```

## 나의풀이



## 필요개념

- `Priority Queue` 를 사용
  - `compareTo` 도 사용할듯?
- 우선순위큐가 작동하는 내부 동작 방법에 대해 찾아보자

- **다차원배열**

  - `int[] [] a = new int [2] [3]`

    2행 3열 의 배열

