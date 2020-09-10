## 강의풀이

```java
package main;

import java.io.*;
import java.util.HashSet;
import java.util.Set;


public class JewelsAndStones {
    public static void main(String[] args) throws IOException {
        String J = "aA", S = "aAAbbbb";
        System.out.println(sovle(J, S));
        
    }

    private static int sovle(String j, String s) {
        //담을곳
        Set<Character> set = new HashSet<>();

        //문제해결부분
        for (char jewel : j.toCharArray()) {
            System.out.println("jewel: "+jewel);
            set.add(jewel); //a , A 
            
        }
        int count = 0;
        for (char stoneChar : s.toCharArray()) {          
            System.out.println("stoneChar : " + stoneChar);
            if(set.contains(stoneChar)){ //a, A 가 포함되어있으면
                count++;
            }
        }
        return count;
    }
    
}

```



## 나의풀이



## 필요개념

- `set` 
  - `hashSet` , 중복을 허용하지 않는 특징을 가지고 있음.
- 보석은 대소문자를 갖고 있어야함.
- aA -> 2개 
- 스톤에서 개별적으로 보석이 있어야함.



### set

![](https://lh3.googleusercontent.com/HdoMZNUTnTsTRCktFr0YVIVVjATyPhSmy1aJfOUlHkmEOmwkwu0EPzO3_bKZpldlfzFdYQBzw3YyWvOpZ4n4Xiw2oK-n6g4w74hU2f_zPNrWHRULdHmFq7Ohww4cE7P37yeUvq1Xfv6jvYsLxnshMqy2Wv82k1DY2vf4lN3oYO-pEB91Tyziz5Foodrv61RfsF6hMjyRBEK4vKv_ZEoVfT2q3WFZk0cZUnoSEHRh1ueO3d3Hy10h_tFdJwP0Zcm2r5EL5uN36MVZSTww76jaEIo4bSpodnr8nx2IdAXEfieFe6E2s6L7AeqzX9bJ1tVpqLtYGH-9joTT47OF50jXJb7i8FSmsVw5rMBPUi_I_ecnP1QZKyInN1ZuQapStIBS6YAq6n4q9IfFbsW4p5GSJVVkSI09mnSSGC3ykhCzeYatGiJXpawzT--SEVqOzD9cmOt5QvDsP6dyPaR8dPcaIsH3jseAHCieOaYvac_TksogOPqdrHLM9TJ2RcZ8Gu-pIweGGqK6xXP1kYnDmVuiVbQSAlgC2FKRtfx-c2VS63G4NDEb9jxUKlf4vLeCIg03pGroydOmbsoUsFzLX1ZgbC8Ip9zjsZQMt_ascis=w632-h527-no)

- 구현 클래스

|    클래스     |                             특징                             |
| :-----------: | :----------------------------------------------------------: |
|    HashSet    | 순서가 필요없는 데이터를 hash table에 저장. Set 중에 가장 성능이 좋음 |
|    TreeSet    | 저장된 데이터의 값에 따라 정렬됨. red-black tree 타입으로 값이 저장. HashSet보다 성능이 느림 |
| LinkedHashSet | 연결된 목록 타입으로 구현된 hash table에 데이터 저장. 저장된 순서에 따라 값이 정렬. 셋 중 가장 느림 |



- HashSet() 생성자
  - 초기 저장용량(initial capacity)가 16
  - load factor는 0.75
    - 공식은..? <u>저장된 element의 수 == 저장용량 * load factor</u>
  - 저장용량이 고정되어있고, element가 증가하면, load factor가 증가. 그러다가 0.75에 다달으면 저장용량을 약 2배로 증가한다. 그런데  이 과정이 자원을 많이 잡아먹음. --> 오버헤드 발생가능성..?

- HashSet() 메소드

![](https://lh3.googleusercontent.com/oJOIcgGVlgUz0ItdpZn8Wm1ObMvpGA1quZlKTE-_bruR1N6hnMMavqb00xPaQA-5HnGIWW4v_vmiumFaoYGpan-aGXEdFv-Iyi86oBEVmV8Vv97wMXx7ETlU25CgemxTk1V600dm7PmWVzVbBNKc4mZ2-UW9VcGiSTMEGh-qJN5buNI1S2Ogc0IORwtEwM_U6-Vjz4cS9VXSolRb3t3KGLzXD_oH2Ly8VoM0C4uG1S54pczFhskzpzdbp3PIaW_qYDCz3msgeUPNoBAIUBe_DTmT9JrpJjOAu2hLMO26kHHuqefQ6Vza0HK1lOAZlMmUgbZa67PTJb0JuRmzyWnR9of9nsOl9BGar-OccK9koUuYc8vvR5Cl5EvBEFhJDk4zKtOYrpVyGUKSMgjmu9ylfhBWPPh5oE7KejudTL5sk3Wu73tYu7yOiK53xWcxmcXjJC1lP-v7x9-tQh1JT0ehgnqIU0EYS38YJl4AhultBcE3TkbM0eB5THMHY9ptHSqxwKmuSLe6GWVWD_EDo_vEFc43MrIHrP_1CJ4CI2HDd2WXXBBT8I0uCB_IYiqs32GnWn1uNc8Oa8Q0blBA89h_4ACQ-CX_VquM8OIHVJU=w1335-h612-no)



> 참고

https://onsil-thegreenhouse.github.io/programming/java/2018/02/21/java_tutorial_1-23/