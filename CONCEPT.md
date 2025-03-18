기본 개념 정리
---
## 1. 소수 찾기
- 소수: 1과 자기 자신만을 약수로 갖는 수
- 2부터 제곱근까지 나눠 떨어지는 수가 있는지 확인
```
public boolean isPrime(int num) {
    if (num <= 1) return false; // 1 이하의 수는 소수가 아님
    for (int i = 2; i <= Math.sqrt(num); i++) {  // √n까지 나눠보기
        if (num % i == 0) return false;  // 나눠지면 소수가 아님
    }
    return true;  // 나눠지지 않으면 소수
}
```

## 2. 피보나치 수열
- 피보나치 수열: 앞의 두 수를 더한 값이 다음 수가 되는 수열
- 재귀 함수 또는 반복문으로 구현
```
public int fibonacci(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];  // 이전 두 값의 합
    }
    return dp[n];
}
```
