# 항상 x가 큰 값으로 둔다.
def compare(wx, wy, tx, ty):
    if wx < tx:
        return True
    if wy < ty:
        return True
    return False
    

def solution(wallet, bill):
    answer = 0
    wx, wy = wallet[0], wallet[1]
    if wx < wy:
        wx, wy = wy, wx
    tx, ty = bill[0], bill[1]
    if tx < ty:
        tx, ty = ty, tx
        
    while compare(wx, wy, tx, ty):
        tx = tx // 2
        if tx < ty:
            tx, ty = ty, tx
        answer += 1
        
    return answer