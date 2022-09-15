def proper_string(strings):
    stk = []
    for s in strings:
        if s == ')':
            if not stk:
                return False
            stk.pop()
        else:
            stk.append('(')
    if not stk:
        return True
    return False


# ))((() -> ))(( ()
def split_balance(strings):
    lCount, rCount, idx = 0, 0, 0
    for s in strings:
        if s == '(':
            lCount += 1
        else:
            rCount += 1
        if lCount == rCount:
            return strings[:idx + 1], strings[idx + 1:]
        idx += 1


def reverse_bracket(strings):
    result = ''
    for s in strings:
        if s == ')':
            result += '('
        else:
            result += ')'
    return result


def solution(p):
    if p == "":
        return ""

    # 균형잡힌 문자열로 분리
    u, v = split_balance(p)

    # u가 올바른 문자열이면 v 재귀
    if proper_string(u):
        return u + solution(v)

    result = "(" + solution(v) + ")" + reverse_bracket(u[1:-1])
    return result
