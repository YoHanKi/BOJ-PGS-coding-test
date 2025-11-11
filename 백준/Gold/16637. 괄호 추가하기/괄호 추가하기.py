N = int(input())
expression = input().strip()

max_result = -float('inf')
operators = []
numbers = []
for i in range(N):
    if i % 2 == 0:
        numbers.append(int(expression[i]))
    else:
        operators.append(expression[i])

def calculate(a, b, op):
    if op == '+':
        return a + b
    elif op == '-':
        return a - b
    elif op == '*':
        return a * b

def dfs(index, current_result):
    global max_result
    if index >= len(operators):
        max_result = max(max_result, current_result)
        return

    next_result = calculate(current_result, numbers[index + 1], operators[index])
    dfs(index + 1, next_result)

    if index + 1 < len(operators):
        next_num = calculate(numbers[index + 1], numbers[index + 2], operators[index + 1])
        next_result = calculate(current_result, next_num, operators[index])
        dfs(index + 2, next_result)

dfs(0, numbers[0])
print(max_result)