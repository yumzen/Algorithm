# 11866번 요세푸스 문제0

# sys 라이브러리의 readline()함수를 사용하면 시간 초과를 피할 수 있다.
import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())

num = list(range(1, n + 1))

print(num)

ans = deque()

i = 0
while len(num) > 0:
    i = (i + k - 1) % len(num)
    ans.append(num.pop(i))

print("<" + ", ".join(map(str, ans)) + ">")
