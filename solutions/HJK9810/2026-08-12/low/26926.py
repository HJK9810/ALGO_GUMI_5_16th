def algorithm():
    SIZE = int(input())
    books = list(map(int, input().split()))

    max_score = 0
    for start in range(0, SIZE // 2 + 1):
        score = 0
        for idx in range(start + 1, SIZE):
            if books[idx] < books[start]: score += 1

        if max_score < score: max_score = score

    return max_score

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
