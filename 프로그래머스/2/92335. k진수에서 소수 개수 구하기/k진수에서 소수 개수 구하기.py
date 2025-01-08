def convert(n, k):
    ref = ""

    while n != 0:
        ref = str(n % k) + ref
        n //= k

    return ref

def isPrime(num):
    if num == 1:
        return False

    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False

    return True

def solution(n, k):
    numString = convert(n, k)
    numArr = numString.split("0")

    answer = 0
    for num in numArr:
        if num != "":
            answer += (isPrime(int(num)))

    return answer