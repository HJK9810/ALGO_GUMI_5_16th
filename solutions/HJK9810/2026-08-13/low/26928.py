def check_count(end, target):
    left = 1
    right = end
    count = 0

    while left < right:
        center = (left + right) // 2
        if center < target:
            left = center
        elif center > target:
            right = center
        else:
            break

        count += 1

    return count

def algorithm():
    P, PA, PB = map(int, input().split())

    A_count = check_count(P, PA)
    B_count = check_count(P, PB)

    if A_count == B_count: return 0
    elif A_count > B_count: return 'B'
    else: return 'A'

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
