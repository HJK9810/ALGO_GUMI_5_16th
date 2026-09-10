def algorithm():
    D, S = map(int, input().split())

    stack = []
    for num in range(10):
        stack.append((D - 1, num))

    count = 0
    while stack:
        left, total = stack.pop()

        if total > S or left < 0: continue
        if total == S and left == 0:
            count += 1
            continue

        for num in range(10):
            stack.append((left - 1, total + num))

    return count

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
