import sys
list = []
for i in range(3):
    n = int(sys.stdin.readline())
    s = 0
    for j in range(n):
        a = int(sys.stdin.readline())
        s += a
    if s>0: print("+")
    elif s<0: print("-")
    else: print("0")