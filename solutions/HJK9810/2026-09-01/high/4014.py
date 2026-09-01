def transit(boards, N):
    for col in range(N):
        for row in range(col):
            boards[row][col], boards[col][row] = boards[col][row], boards[row][col]

    return boards
    

def count_line(line, X):
    is_down = False
    change_count = 1

    for col in range(1, len(line)):
        current = line[col]
        before = line[col - 1]

        if line[col] == line[col - 1]:
            if is_down:
                change_count += 1
                if change_count == X:
                    is_down = False
                    change_count = 0
            else: change_count += 1
        elif abs(current - before) != 1: return False
        elif before < current:
            if is_down or change_count < X: return False
            else: change_count = 1
        elif before > current:
            if is_down: return False

            is_down = X != 1
            change_count = 0 if X == 1 else 1

    return not is_down

def algorithm():
    N, X = map(int, input().split())
    boards = [list(map(int, input().split())) for _ in range(N)]

    count = 0
    for row in range(N):
        if (count_line(boards[row], X)): count += 1

    board_transit = transit(boards, N)
    for row in range(N):
        if (count_line(board_transit[row], X)): count += 1

    return count

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
