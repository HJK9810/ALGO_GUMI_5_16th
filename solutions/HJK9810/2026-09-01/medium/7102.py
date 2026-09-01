def algorithm():
    N, M = map(int, input().split())
    sum_list = [0] * (N + M + 1)

    for first in range(1, N + 1):
        for second in range(1, M + 1):
            sum_list[first + second] += 1

    max_count = 0
    for num in range(len(sum_list)):
        if max_count < sum_list[num]:
            max_count = sum_list[num]

    result = []
    for num in range(len(sum_list)):
        if sum_list[num] == max_count: result.append(str(num))

    return " ".join(result)

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
