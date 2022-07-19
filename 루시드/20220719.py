import sys
from bisect import bisect

sys.setrecursionlimit(10 ** 6)


def postorder(s, e):
    if s == e:
        return

    d = preorder[s]
    idx = bisect(preorder, d, s, e)
    postorder(s + 1, idx)  # postorder(5, 5) 들어가면 멈춘다.
    postorder(idx, e)  # postorder(5, 5) 들어가면 멈춘다. 즉 이 다음에는 preorder[5-1]의 위치에 있던 값이 나온다.
    print(d)


preorder = []
while True:
    try:
        preorder.append(int(sys.stdin.readline()))

    except:
        break

postorder(0, len(preorder))
