def algorithm():
    line = list(input())
    stack = []

    for alpa in line:
        stack.append(alpa)
        if len(stack) < 2: continue

        while len(stack) > 1 and stack[-1] == stack[-2]:
            stack.pop()
            stack.pop()

    return len(stack)

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
