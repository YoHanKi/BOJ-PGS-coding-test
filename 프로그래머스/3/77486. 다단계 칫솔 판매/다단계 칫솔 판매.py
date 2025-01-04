def cal(name, price):
    global money, tree

    percent10 = int(price * 0.1)
    money[name] += price - percent10

    if percent10 == 0:
        return

    if name != '-':
        cal(tree[name], percent10)

def solution(enroll, referral, seller, amount):
    global money, tree

    money = dict()
    money['-'] = 0
    for name in enroll:
        money[name] = 0

    tree = dict()
    for child, parent in zip(enroll, referral):
        tree[child] = parent

    for name, price in zip(seller, amount):
        cal(name, price * 100)

    return [money[name] for name in enroll]