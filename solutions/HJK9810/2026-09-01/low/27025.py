def algorithm():
    N = int(input())
    numbers = list(map(int, input().split()))
    K = int(input())
    cancels = list(map(int, input().split()))

    for idx in range(N):
        for index in range(K):
            if numbers[idx] == cancels[index]:
                numbers[idx] = 0
                cancels[index] = 0
                break

    members = [str(num) for num in numbers if num != 0]
    return " ".join(members) if len(members) > 0 else "empty"

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
