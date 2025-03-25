N = int(input())

cols = [False] * N
diags1 = [False] * (2 * N - 1)
diags2 = [False] * (2 * N - 1)

def dfs(row):
    global count

    if row == N:
        count += 1
        return

    for col in range(N):
        if cols[col] or diags1[row + col] or diags2[row - col + N - 1]:
            continue

        cols[col] = True
        diags1[row + col] = True
        diags2[row - col + N - 1] = True

        dfs(row + 1)

        cols[col] = False
        diags1[row + col] = False
        diags2[row - col + N - 1] = False

count = 0
dfs(0)
print(count)