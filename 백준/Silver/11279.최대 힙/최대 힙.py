import heapq
import sys

ans = []
n = int(sys.stdin.readline())

for i in range(n):
    x = int(sys.stdin.readline())
    if x != 0:
        heapq.heappush(ans, -x)
    else:
        if ans:
            print(-heapq.heappop(ans))
        else:
            print(0)
