> https://leetcode.com/problems/count-primes

## 나의풀이

```java
class Solution {
    public int countPrimes(int n) {
        int answer = 0;
        int[] nums = new int[n];

        for (int i = 2; i < n; i++) {
            nums[i] = i;
        }

        for (int i = 2; i < n; i++) {
            if(nums[i] == 0) continue;

            for(int j = 2 * i; j < n; j +=i) {
                nums[j] = 0;
            }
        }

        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != 0) answer++;
        }

        return answer;
    }
}

```

## 다른 풀이

```java

class Solution {
    public int countPrime(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
            }
            for (int j = 2; i*j < n; j++) {
                notPrime[i*j] = true;
            }
        }
        return count;
    }
}

```

- prime이 아닌 수들을 기록해놓을 `boolean` 배열을 만들고,
- 이중 for문 안에서, i의 배수들은 소수에 해당하지 않으니, mark해 놓고

## 필요개념

- 에라토스테네스의 체를 이용하여 구현
- 시간복잡도는 `O(n) * O(log(log(n)))`
- https://leetcode.com/problems/count-primes/discuss/473021/Time-Complexity-O(log(log(n)
