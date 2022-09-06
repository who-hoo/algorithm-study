from collections import defaultdict

def solution(str1, str2):
    m1, m2 = defaultdict(int), defaultdict(int)

    extract_map(m1, str1)
    extract_map(m2, str2)

    m1_keys, m2_keys = set(m1.keys()), set(m2.keys()),

    kyo = m1_keys.intersection(m2_keys)
    hap = m1_keys.union(m2_keys)

    kyo_count, hap_count = 0, 0

    for k in kyo:
        kyo_count += min(m1[k], m2[k])

    for h in hap:
        hap_count += max(m1[h], m2[h])

    if hap_count == 0:
        return 65536

    return int((kyo_count / hap_count) * 65536)


def extract_map(m1, str1):
    for i in range(len(str1) - 1):
        sub = str1[i:i + 2].lower()
        if sub.isalpha():
            m1[sub] += 1
