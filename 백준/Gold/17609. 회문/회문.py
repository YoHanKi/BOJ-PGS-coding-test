def check(l, r):
    global s

    while l < r:
        if s[l] != s[r]:
            return False

        l += 1
        r -= 1

    return True


N = int(input())

for _ in range(N):
    s = input()

    l = 0
    r = len(s) - 1

    is_palindrome = True
    is_pseudo = True

    while l < r:
        if s[l] != s[r]:
            is_palindrome = False
            break

        l += 1
        r -= 1

    if is_palindrome:
        print(0)
    elif (check(l + 1, r) or check(l, r - 1)) and not is_palindrome:
        print(1)
    else: print(2)