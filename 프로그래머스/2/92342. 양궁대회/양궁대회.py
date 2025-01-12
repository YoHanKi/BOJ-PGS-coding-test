from itertools import combinations_with_replacement

def get_cur_point(a_array, l_array):
    a = 0
    l = 0
    for i in range(11):
        if a_array[i] == 0 and l_array[i] == 0:
            continue
        if a_array[i] >= l_array[i]:
            a += 10 - i
        else :
            l += 10 - i

    return l - a

def solution(n, info):
    win_point = 0
    win_array = [0] * 11

    for comb in combinations_with_replacement(range(11), n):
        cur_array = [0] * 11

        for index in comb:
            cur_array[index] += 1

        cur_point = get_cur_point(info, cur_array)

        if (win_point < cur_point) or (win_point == cur_point and win_array[::-1] < cur_array[::-1]):
            win_point = cur_point
            win_array = cur_array[:]

    return [-1] if win_point == 0 else win_array