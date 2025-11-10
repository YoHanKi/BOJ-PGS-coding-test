import sys
import bisect

input = sys.stdin.readline
N = int(input().strip())
sequence = list(map(int, input().split()))

tails = []
tails_idx = []
prev = [-1] * N

for i, x in enumerate(sequence):
    pos = bisect.bisect_left(tails, x)
    if pos == len(tails):
        tails.append(x)
        tails_idx.append(i)
    else:
        tails[pos] = x
        tails_idx[pos] = i
    if pos > 0:
        prev[i] = tails_idx[pos - 1]

length = len(tails)
last_index = tails_idx[-1]

result = []
while last_index != -1:
    result.append(sequence[last_index])
    last_index = prev[last_index]
result.reverse()

print(length)
print(' '.join(map(str, result)))