N = int(input())
M = int(input())
broken_buttons = map(int, input().split()) if M > 0 else []
buttons = [True] * 10
for b in broken_buttons:
    buttons[b] = False

def can_press(channel):
    if channel == 0:
        return buttons[0]
    while channel > 0:
        digit = channel % 10
        if not buttons[digit]:
            return False
        channel //= 10
    return True

min_presses = abs(N - 100)
for channel in range(1000001):
    if can_press(channel):
        presses = len(str(channel)) + abs(channel - N)
        if presses < min_presses:
            min_presses = presses

print(min_presses)