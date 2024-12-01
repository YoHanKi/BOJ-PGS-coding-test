N, M = map(int, input().split())
arr = list(map(int, input().split()))

pos = []
neg = []

for i in arr:
    if i > 0:
        pos.append(i)
    else:
        neg.append(-i)

pos.sort(reverse=True)
neg.sort(reverse=True)

dist = []

for p in pos[::M]:
    dist.append(p)

for n in neg[::M]:
    dist.append(n)

ans = (sum(dist) *2) - max(dist)

print(ans)