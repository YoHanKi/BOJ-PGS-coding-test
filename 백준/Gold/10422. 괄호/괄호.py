import sys
MOD = 1000000007

input_data = sys.stdin.read().strip().split()
T = int(input_data[0])
Ls = list(map(int, input_data[1:]))

maxL = max(Ls)
maxN = maxL  # factorial까지 maxL 필요 (2n <= maxL)
fac = [1] * (maxN + 1)
for i in range(1, maxN + 1):
    fac[i] = fac[i-1] * i % MOD
invfac = [1] * (maxN + 1)
invfac[maxN] = pow(fac[maxN], MOD-2, MOD)
for i in range(maxN, 0, -1):
    invfac[i-1] = invfac[i] * i % MOD

out_lines = []
for L in Ls:
    if L % 2 == 1:
        out_lines.append("0")
        continue
    n = L // 2
    # binom(2n, n)
    binom = fac[2*n] * invfac[n] % MOD * invfac[n] % MOD
    catalan = binom * pow(n+1, MOD-2, MOD) % MOD
    out_lines.append(str(catalan))

print("\n".join(out_lines))