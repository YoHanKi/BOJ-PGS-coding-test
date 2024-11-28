def permutation(level):
    global N, choose, check

    # base case
    if level == N:
        print(' '.join(map(str, choose)))
        return

    # recursive case
    for i in range(1, N + 1):
        if check[i]:
            continue

        choose.append(i)
        check[i] = True

        permutation(level + 1)

        choose.pop()
        check[i] = False

N = int(input())

choose = []
check = [False] * (N + 1)

permutation(0)