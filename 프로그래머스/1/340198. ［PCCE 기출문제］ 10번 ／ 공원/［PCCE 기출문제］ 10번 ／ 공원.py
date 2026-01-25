PARK = []
ROWS = 0
COLS = 0

def check(size, r, c):
    global PARK, ROWS, COLS
    
    if r + size > ROWS or c + size > COLS:
        return False
    
    for i in range(r, r + size):
        for j in range(c, c + size):
            if PARK[i][j] != "-1":
                return False
    return True
                

def solution(mats, park):
    global PARK, ROWS, COLS
    
    PARK = park
    ROWS = len(park)
    COLS = len(park[0])
    
    mats.sort(reverse=True)
    
    for size in mats:
        for r in range(ROWS):
            for c in range(COLS):
                if check(size, r, c):
                    return size
    
    return -1