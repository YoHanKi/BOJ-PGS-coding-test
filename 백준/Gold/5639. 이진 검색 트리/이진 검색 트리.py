import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

arr = []
while True:
    try:
        arr.append(int(input()))
    except:
        break

def tree(start, end):
    # base case
    if start > end:
        return

    # recursive case
    mid = end + 1
    for i in range(start + 1, end + 1):
        if arr[start] < arr[i]:
            mid = i
            break

    tree(start + 1, mid - 1)
    tree(mid, end)
    print(arr[start])

tree(0, len(arr) - 1)