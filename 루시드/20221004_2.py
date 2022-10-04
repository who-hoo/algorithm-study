def solution(enroll, referral, seller, amount):
    relation = dict()

    for idx, name in enumerate(enroll):
        relation[name] = [referral[idx], 0]  # parent, amount of Price

    for idx, sellerName in enumerate(seller):
        money = amount[idx] * 100
        share = money // 10
        currentSeller = sellerName
        parentSeller = relation[currentSeller][0]

        afterShare = money
        while True:
            if share >= 1:
                afterShare -= share

            relation[currentSeller][1] += afterShare

            if parentSeller == '-' or share < 1:
                break

            afterShare = share
            share = afterShare // 10

            currentSeller = parentSeller
            parentSeller = relation[currentSeller][0]

    return list(value[1] for value in relation.values())
