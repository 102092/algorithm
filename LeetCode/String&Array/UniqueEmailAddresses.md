## 강의풀이

```java
package app;

import java.util.*;

public class UniqueEmailAddress {
    public static void main(String[] args) throws Exception {
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = {"test.email+james@coding.com",
                            "test.e.mail+toto.jane@coding.com",
                            "testemail+to@cod.ing.com"};
        System.out.println(a.numUniqueEmails(emails));
        
    }

    private int numUniqueEmails(String[] emails) {
        //답을 담을 공간
        Set<String> set = new HashSet<>();

        //데이터 정제
        for (String email : emails) {
            String localName = makeLocalName(email);
            String domainName = makeDomainName(email);
            set.add(localName+ "@" + domainName);
            
        }
        return set.size(); //2가 나올것

    }

    private String makeDomainName(String email) { //@로 시작하는 애들 담으면 됨.

        return email.substring(email.indexOf('@')+1);
    }

    private String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();

        
        for (int i = 0; i < email.length(); i++) {
            //에러체크
            if(email.charAt(i) =='.'){
                continue;
            }
            if (email.charAt(i) =='+'){
                break;
            }
            if (email.charAt(i) =='@'){
                break;
            }
            //sb에 append
            String str = String.valueOf(email.charAt(i)); //testemail이 나와야하고
            sb.append(str);
        }
        return sb.toString();
    }

}
```

## 나의풀이



## 필요개념

- subString
- break, continue

- Stringbuilder

- HashSet
  - set 인터페이스의 구현 클래스
  - **순서가 없고, 중복 불가**, 중복해서 저장하지 않는 클래스!
  - HashSet에서는 순서가 없기 때문에, 특정 위치의 데이터를 읽어올 수 있는 방법이 없으므로, `Iterator` 를 활용하여 전체 데이터를 불러와야함.