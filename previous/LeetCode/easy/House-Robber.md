> https://leetcode.com/problems/house-robber/

## 나의풀이

```java

```

## 필요개념

- Dynamic Programming 에 대한 이해가 필요한듯

  1.재귀적인 관계를 찾던지

  2. top - down 방식으로 재귀적으로 파고 드는 것이던지
  3. 반복문 이용, 어딘가 메모하는 방식 (top-down)
  4. 3번과 같으면서 (down - top)
  5. 반복문 + N개의 변수기반 down - top?

#### step1

- 문제에는 2가지 옵션이 있음. 1. 지금 있는 집을 털든지, 2. 아니면 지금 있는 집을 안 털던지.
- 1번을 선택한다는 의미는, 인접한 집을 털지 못한다는 의미. 즉 i - 1 집은 털지 않고 지나왔음.
- 2번을 선택한다는 의미는, 아마도 이 전에 있던 집을 털었을 가능성이 있음.
- `rob(i) = Math.max(rob(i - 2) + robCurrnetHouseValue, rob(i - 1));`
- 위와 같이 정의할 수 있음.

#### step2

```java
public int rob(int[] nums) {
    return rob(nums, nums.length-1);
}

private int rob(int[] nums, int i) {
    if(i < 0) {
        return 0;
    }
    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
}
```

- 재귀적으로 찾아감.
- 이 방식으로 풀면, `Time Limit Exceeded` 발생
- 추상적인 풀이 방식을, 코드로 구현하는 것이 생각보다 어렵

#### step3

```java
public int rob(int[] nums) {
    int[] memo = new int[nums.length + 1];
    Arrays.fill(memo , -1); // 해당 배열을 -1로 채운 후에
    return rob(memo , nums, nums.length -1);
}

private int rob(int[] memo, int nums, int i) {
    if(i < 0) {
        return 0;
    }

    if(memo[i] >= 0) {
        return memo[i];
    }

    int result = Math.max(rob(memo, nums, i - 2) + nums[i], rob(memo, nums, i - 1));
    memo[i] = result;
    return result;
}
```

- 한번 계산한 것은 다시 계산하지 않도록 하려고, memo 배열을 사용.
- 재귀에서 일어날 수 있는 시간 초과 문제를 해결하기 위해서 사용.
- memo 배열을 1을 추가해서 만드는 이유는?
  - memo[0] 는 .....?

#### step4

```java
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int[] memo = new int[nums.length + 1];
    memo[0] = 0;
    memo[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int val = nums[i];
        memo[i+1] = Math.max(memo[i-1] + val, memo[i]);
    }
    return memo[nums.length];
}
```

- 반복문 쓰면서, bottom - up 방식
- 재귀문을 쓰지 않고도, 단순히 메모하는 방식으로도 대체할 수 있음.

#### step5

```java

public int rob(int[] nums) {
    if(nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num : nums) {
        int temp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = temp;
    }
    return prev1;
}
```
