def algorithm():
    line = list(input())
    stack = []

    cut_count = 0
    is_cut_avail = False

    for alpa in line:
        if alpa == '(':
            is_cut_avail = True
            stack.append(alpa)
            continue

        if is_cut_avail:
            is_cut_avail = False
            stack.pop()
            cut_count += len(stack)
        else:
            stack.pop()
            cut_count += 1

    return cut_count

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
