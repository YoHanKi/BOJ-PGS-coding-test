s = input()

while s != '.':
    n = len(s)
    lps = [0] * n
    j = 0

    for i in range(1, n):
        while j > 0 and s[i] != s[j]:
            j = lps[j - 1]
        if s[i] == s[j]:
            j += 1
            lps[i] = j

    pattern_length = n - lps[-1]
    if n % pattern_length == 0:
        print(n // pattern_length)
    else:
        print(1)

    s = input()