def algorithm():
    K, N, M = map(int, input().split())
    spots = list(map(int, input().split()))
    spots.sort()
    spots.insert(0, 0)

    current_idx = 0
    count = 0
    while current_idx < M + 1:
        next_idx = current_idx

        if N - spots[current_idx] <= K: break
        for idx in range(current_idx + 1, M + 1):
            if spots[idx] - spots[current_idx] > K: break
            next_idx = idx

        if next_idx == current_idx:
            count = 0
            break
        current_idx = next_idx
        count += 0

    return count

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
