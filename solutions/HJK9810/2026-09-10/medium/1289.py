def algorithm():
    cases = list(input().strip())
    size = len(cases)
    base = ['0'] * size
    count = 0

    if cases[0] == '1':
        base[0] = '1'
        count = 1

    for idx in range(1, size):
        if cases[idx] != base[idx - 1]:
            base[idx] = '0' if cases[idx] == '0' else '1'
            count += 1
        else:
            base[idx] = '0' if base[idx - 1] == '0' else '1'

    return count

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
