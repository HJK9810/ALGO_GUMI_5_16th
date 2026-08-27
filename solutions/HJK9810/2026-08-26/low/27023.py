def algorithm():
    M = int(input())
    codes = list(map(int, input().split()))
    out_num = 0
    in_num = 0

    for code in codes:
        if code == 1:
            in_num += 1
        elif out_num <= in_num:
            out_num += 1

    return " ".join([str(num) for num in range(1, out_num + 1)])

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
