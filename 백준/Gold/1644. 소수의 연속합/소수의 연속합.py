import math

N = int(input())

def is_prime_arr():
    global N
    prime = [True] * (N + 1)
    prime[0] = prime[1] = False
    for i in range(2, int(math.sqrt(N)) + 1):
        if prime[i]:
            for j in range(i * i, N + 1, i):
                prime[j] = False

    return [i for i in range(N + 1) if prime[i]]

primes = is_prime_arr()
if not primes:
    print(0)
    exit()
start, end = 0, 0
current_sum = primes[0]
count = 0

while True:
    if current_sum >= N:
        if current_sum == N:
            count += 1
        current_sum -= primes[start]
        start += 1
    else:
        end += 1
        if end >= len(primes):
            break
        current_sum += primes[end]

print(count)