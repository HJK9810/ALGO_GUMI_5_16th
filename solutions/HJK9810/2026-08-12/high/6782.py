import math

def algorithm():
    N = int(input())
    count = 0

    while N >= 2:
        if N == 2: break

        sqrt_N = math.sqrt(N)
        if sqrt_N == int(sqrt_N):
            N = sqrt_N
            count += 1
        else:
            next_sqrt = int(sqrt_N) + 1
            count += (next_sqrt ** 2 - N + 1)
            N = next_sqrt

    return count

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
