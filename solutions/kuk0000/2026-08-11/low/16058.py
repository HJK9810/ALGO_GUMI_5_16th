T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input.split())
    step_arr = list(map(int, input().split()))
    temp = sum(step_arr[0:M])
    max_sum = temp
    min_sum = temp
    for i in range(N-M+1):
        temp = temp - step_arr[i-1]+step_arr[i+M-1]
        max_sum = max(max_sum, temp)
        min_sum = min(min_sum, temp)

    print(f'#{test_case} {max_sum - min_sum}')