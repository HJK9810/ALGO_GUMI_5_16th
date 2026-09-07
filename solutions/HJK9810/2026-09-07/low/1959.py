def algorithm():
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    loop_size = abs(M - N) + 1
    min_size = min(N, M)
    max_total = float('inf') * -1

    for start in range(loop_size):
        total = 0
        for idx in range(min_size):
            if N < M:
                total += (A[idx] * B[idx + start])
            else:
                total += (A[idx + start] * B[idx])
        max_total = max(max_total, total)

    return max_total

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
