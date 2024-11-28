vows = ['a', 'e', 'i', 'o', 'u']
choose = []

def combination(idx, dep):
    global L, C, arr, choose

    if dep == L:
        count = 0
        for i in choose:
            count += (i in vows)

        other = L - count

        if count >= 1 and other >= 2:
            print(''.join(choose))
        return

    for i in range(idx, C):
        choose.append(arr[i])
        combination(i + 1, dep + 1)
        choose.pop()


L, C = map(int, input().split())
arr = input().split()

arr.sort()

combination(0, 0)