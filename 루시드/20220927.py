def find_first_Number(string):
    for idx, s in enumerate(string):
        if str(s).isnumeric():
            end = idx + 1
            while end < len(string):
                if not string[end].isnumeric():
                    break
                end += 1
            return int(string[idx:end])


def find_first_string(string):
    for idx, s in enumerate(string):
        if str(s).isnumeric():
            return string[:idx].lower()


def solution(files):
    sortedByNumber = sorted(files, key=lambda file: find_first_Number(file))
    return sorted(sortedByNumber, key=lambda file: find_first_string(file))
