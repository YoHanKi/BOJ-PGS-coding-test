def solution(id_list, report, k):
    id_set = set()
    for r in report:
        reporter, reported = r.split()
        id_set.add((reporter, reported))

    count_dict = {name : 0 for name in id_list}
    report_dict = {name : set() for name in id_list}

    for reporter, reported in id_set:
        report_dict[reporter].add(reported)
        count_dict[reported] += 1


    answer = []
    for name in id_list:
        cnt = 0
        for reported in report_dict[name]:
                cnt += (count_dict[reported] >= k)
        answer.append(cnt)

    return answer