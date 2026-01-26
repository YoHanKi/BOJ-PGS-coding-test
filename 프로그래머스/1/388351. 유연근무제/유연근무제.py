"""
    주말(6,7)은 제외한 나머지(1~5) 일자에 기존 시간 + 10분 이내에 모두 출근했다면 정상 출근으로 인정하여 result + 1
"""
NOW = 0
CUR = 0

def append_time(time):
    h = time // 100
    m = time % 100
    m += 10
    if m >= 60:
        h += 1
        m -= 60
    return h * 100 + m


def solution(schedules, timelogs, startday):
    global NOW, CUR
    
    NOW = startday
    members = [True] * len(schedules)
    
    while CUR != 7:
        if NOW == 6 or NOW == 7:
            CUR += 1
            NOW = 1 if (NOW + 1) % 8 == 0 else (NOW + 1) % 8
            continue
            
        for i in range(len(schedules)):
            if members[i]:
                if append_time(schedules[i]) < timelogs[i][CUR]:
                    members[i] = False
                
        CUR += 1
        NOW = 1 if (NOW + 1) % 8 == 0 else (NOW + 1) % 8
        
    return sum(members)