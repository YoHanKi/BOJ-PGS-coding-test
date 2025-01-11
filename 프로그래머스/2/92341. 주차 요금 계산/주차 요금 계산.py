from math import ceil

def cal_fee(total_time, common_time, common_fee, unit_time, unit_fee):
    if total_time <= common_time:
        return common_fee

    total_fee = common_fee
    total_time -= common_time
    total_fee += ceil(total_time / unit_time) * unit_fee

    return total_fee

def getMin(time):
    hour, min = map(int, time.split(":"))
    return hour * 60 + min

def solution(fees, records):
    now_parking = set()
    total_time = [0] * 10000
    car_info = [-1] * 10000

    for record in records:
        time, car, yn = record.split()
        time = getMin(time)
        car = int(car)

        if yn == "IN":
            now_parking.add(car)
            car_info[car] = time
        else:
            now_parking.remove(car)
            total_time[car] += time - car_info[car]
            car_info[car] = -1

    for carIn in now_parking:
        total_time[carIn] += (23 * 60 + 59) - car_info[carIn]
        car_info[carIn] = -1

    return [cal_fee(total_time[car], *fees) for car in range(10000) if total_time[car] != 0]