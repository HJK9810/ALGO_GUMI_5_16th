def algorithm():
    nums, count = map(int, input().split())
    boards = list(map(str, nums))

    result = -1

    def change_num(idx, ch_chout, sen):
        if ch_chout == count:
            result = max(result, int(sen))
            return

        for index in len(nums):
            visited[index] = False
            change_num(index, sen + boards[index])


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")