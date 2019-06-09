### 문자열 내 p와 y의 개수

- [링크](<https://programmers.co.kr/learn/courses/30/lessons/12916?language=java>)



> 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
>
> 예를들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

<br>

##### 제한사항

- 문자열 s의 길이 : 50 이하의 자연수
- 문자열 s는 알파벳으로만 이루어져 있습니다.

##### 내 풀이

```java
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        int pc = 0;
        int yc = 0;
        
        char[] temp = s.toCharArray();
        
        for(int i = 0; i < temp.length; i++){
            if(temp[i] =='p'||temp[i]=='P'){
                pc++;
            }else if(temp[i] =='y'||temp[i]=='Y'){
                yc++;
            }
        }
        if(pc == yc){
            answer = true;
        }else{
            answer = false;
        }

        return answer;
    }

```

<br>

##### 다른 사람 풀이

```java
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int p = 0;
        int y = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                p++;

            }
            if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                y++;
            }
        }

        if(p + y == 0){
            return true;
        }

        return p == y;
    }
}

```

- `String` . `charAt` 이 어떤 역할을 하고 있는지 알아보면 좋을 것 같다.
- 'charAt` , String 문장에서 인덱스에 해당하는 한개의 문자를 추출하는 메서드
