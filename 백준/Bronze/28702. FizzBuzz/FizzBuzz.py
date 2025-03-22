arrays = [A, B, C] = [input(), input(), input()]

def printFizzBuzz(next):
    if next % 3 == 0:
        if next % 5 == 0:
            print("FizzBuzz")
        else :
            print("Fizz")

    elif next % 5 == 0:
        print("Buzz")

    else:
        print(next)

def isNumber(string):
    try:
        int(string)
        return True
    except ValueError:
        return False

for i in range(len(arrays)):
    if isNumber(arrays[i]):
        if i == 0:
            printFizzBuzz(int(arrays[i]) + 3)
            break
        elif i == 1:
            printFizzBuzz(int(arrays[i]) + 2)
            break
        else:
            printFizzBuzz(int(arrays[i]) + 1)
            break