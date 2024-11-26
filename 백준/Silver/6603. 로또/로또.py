def func(index, depth):
    global choose, arr, k
    # base case
    if depth == 6:
        for i in choose:
            print(i, end=' ')
        print()
        return

    # recursive case
    for i in range(index, k):
        choose.append(arr[i])
        func(i + 1, depth + 1)
        choose.pop()

while True:
    choose = []
    N = list(map(int, input().split()))

    k = N[0]
    arr = N[1:]

    if k == 0:
        break

    func(0, 0)
    print()