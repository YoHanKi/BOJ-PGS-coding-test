N = input()
length = 0
for digit_count in range(1, len(N) + 1):
    start = 10 ** (digit_count - 1)
    end = min(int(N), 10 ** digit_count - 1)
    length += (end - start + 1) * digit_count
print(length)