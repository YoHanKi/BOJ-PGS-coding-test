N = int(input())
numbers = list(map(int, input().split()))
operators = list(map(int, input().split()))  # [+, -, *, /]

max_result = -10**9
min_result = 10**9

def backtrack(index, current_result, add, sub, mul, div):
    global max_result, min_result

    if index == N:
        max_result = max(max_result, current_result)
        min_result = min(min_result, current_result)
        return

    if add > 0:
        backtrack(index + 1, current_result + numbers[index], add - 1, sub, mul, div)
    if sub > 0:
        backtrack(index + 1, current_result - numbers[index], add, sub - 1, mul, div)
    if mul > 0:
        backtrack(index + 1, current_result * numbers[index], add, sub, mul - 1, div)
    if div > 0:
        if current_result < 0:
            backtrack(index + 1, -(-current_result // numbers[index]), add, sub, mul, div - 1)
        else:
            backtrack(index + 1, current_result // numbers[index], add, sub, mul, div - 1)

backtrack(1, numbers[0], operators[0], operators[1], operators[2], operators[3])
print(max_result)
print(min_result)