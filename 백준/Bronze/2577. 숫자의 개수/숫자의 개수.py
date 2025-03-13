A = int(input())
B = int(input())
C = int(input())

string = str(A * B * C)

array = [0] * 10
for i in string:
    array[int(i)] += 1

for i in range(10):
    print(array[i])