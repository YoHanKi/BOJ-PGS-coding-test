def solution(friends, gifts):
    N = len(friends)
    I = {name : index for name, index in zip(friends, range(N))}
    
    record = [[0] * N for _ in range(N)]
    give = [0] * N
    recive = [0] * N
    
    for gift in gifts:
        g, r = gift.split()
        give[I[g]] += 1
        recive[I[r]] += 1
        record[I[g]][I[r]] += 1
        
    score = [0] * N
    for x in range(N):
        score[x] = give[x] - recive[x]
    
    answer = [0] * N
    for i in range(N):
        for j in range(N):
            if i == j: continue
            case1 = (record[i][j] > record[j][i])
            case2 = (record[i][j] == record[j][i] and score[i] > score[j])
            answer[i] += (case1 or case2)
    
    return max(answer)