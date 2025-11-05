T = input()
P = input()

def kmp_preprocess(pattern):
    m = len(pattern)
    lps = [0] * m
    j = 0

    for i in range(1, m):
        while j > 0 and pattern[i] != pattern[j]:
            j = lps[j - 1]
        if pattern[i] == pattern[j]:
            j += 1
            lps[i] = j
    return lps

def kmp_search(text, pattern):
    n = len(text)
    m = len(pattern)
    lps = kmp_preprocess(pattern)
    j = 0
    positions = []

    for i in range(n):
        while j > 0 and text[i] != pattern[j]:
            j = lps[j - 1]
        if text[i] == pattern[j]:
            j += 1
        if j == m:
            positions.append(i - m + 1)
            j = lps[j - 1]
    return positions

positions = kmp_search(T, P)
print(len(positions))
for pos in positions:
    print(pos + 1)