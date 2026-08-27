from collections import deque

def algorithm():
    data = list(map(int, input().split()))
    queue = deque(data)
    minus = 1

    while queue:
        num = queue.popleft()
        num -= minus
        if num <= 0:
            queue.append(0)
            break

        queue.append(num)
        minus = 1 if minus == 5 else minus + 1

    return " ".join(map(str, queue))

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for _ in range(10):
    test_case = int(input())
    print(f"#{test_case} {algorithm()}")
