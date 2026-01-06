from itertools import permutations

N = int(input())
games = [list(map(int, input().split())) for _ in range(N)]

players = [1,2,3,4,5,6,7,8]
fixed_pos = 3
other_positions = [0,1,2,4,5,6,7,8]

def simulate(order):
    score = 0
    cur = 0

    for inning in range(N):
        outs = 0
        bases = 0

        while outs < 3:
            player = order[cur]
            res = games[inning][player]
            cur = (cur + 1) % 9

            if res == 0:
                outs += 1
            elif res == 4:
                score += bases.bit_count() + 1
                bases = 0
            else:
                k = res
                bases = (bases << k) | (1 << (k - 1))
                score += (bases >> 3).bit_count()
                bases &= 7

    return score

ans = 0
for perm in permutations(players):
    order = [None] * 9
    order[fixed_pos] = 0
    for pos, p in zip(other_positions, perm):
        order[pos] = p

    ans = max(ans, simulate(order))

print(ans)