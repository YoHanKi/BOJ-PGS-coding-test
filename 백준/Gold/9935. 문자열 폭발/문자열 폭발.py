stringLine = input()
bomb = input()

stack = []

for char in stringLine:
    stack.append(char)
    if len(stack) >= len(bomb):
        if ''.join(stack[-len(bomb):]) == bomb:
            for _ in range(len(bomb)):
                stack.pop()

if not stack:
    print("FRULA")
else:
    print(''.join(stack))