def init(base, cases, idx):
    return base[:idx] + cases + base[idx:]

def find_idx(base, case):
    for index in range(len(base)):
        if base[index] > case:
            return index

    return -1

def algorithm():
    N, M = map(int, input().split())
    base = list(map(int, input().split()))
    cases = [list(map(int, input().split())) for _ in range(M - 1)]

    for case in cases:
        start = case[0]
        idx = find_idx(base, start)
        if idx == -1: base.extend(case)
        else: base = init(base, case, idx)

    last_idx = len(base) - 1
    for idx in range(10):
        if last_idx < idx: break
        print(base[last_idx - idx], end=" ")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case}", end=" ")
    algorithm()
    print()
