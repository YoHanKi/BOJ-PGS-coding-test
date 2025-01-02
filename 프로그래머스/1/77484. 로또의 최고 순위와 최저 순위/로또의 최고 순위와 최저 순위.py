def solution(lottos, win_nums):
    zero = 0
    for lotto in lottos:
        zero += (lotto == 0)
        
    cnt = 0
    for lotto in lottos:
        cnt += (lotto in win_nums)
        
    answer = {
        6 : 1,
        5 : 2,
        4 : 3,
        3 : 4,
        2 : 5,
        1 : 6,
        0 : 6
    }
    
    return [answer[cnt + zero], answer[cnt]]