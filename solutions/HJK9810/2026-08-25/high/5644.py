DIR = [(0, 0), (-1, 0), (0, 1), (1, 0), (0, -1)]

def sort_charge(case_num, charge_case):
    sort_case = [num for num in case_num]
    size = len(case_num)

    for idx in range(size - 1, -1, -1):
        for index in range(idx):
            if charge_case[sort_case[index]] < charge_case[sort_case[index + 1]]:
                sort_case[index + 1], sort_case[index] = sort_case[index], sort_case[index + 1]

    return sort_case

def move_pos(current, dir_move):
    row, col = current
    d_row, d_col = DIR[dir_move]
    return [row + d_row, col + d_col]

def initial_baord(num):
    charge_case = [0]
    boards = [[[0] for _ in range(10)] for _ in range(10)]

    for idx in range(num):
        col, row, size, charge = map(int, input().split())
        row -= 1
        col -= 1
        charge_case.append(charge)

        for r in range(row - size, row + size + 1):
            for c in range(col - size, col + size + 1):
                if 0 <= r < 10 and 0 <= c < 10 and abs(r - row) + abs(c - col) <= size:
                    boards[r][c].append(idx + 1)

    return boards, charge_case

def algorithm():
    M, A = map(int, input().split())
    A_move = list(map(int, input().split()))
    B_move = list(map(int, input().split()))

    boards, charge_case = initial_baord(A)
    total_charge = 0

    A_move.insert(0, 0)
    B_move.insert(0, 0)

    A_pos = [0, 0]
    B_pos = [9, 9]
    for move in range(M + 1):
        A_pos = move_pos(A_pos, A_move[move])
        B_pos = move_pos(B_pos, B_move[move])

        A_charge = sort_charge(boards[A_pos[0]][A_pos[1]], charge_case)
        B_charge = sort_charge(boards[B_pos[0]][B_pos[1]], charge_case)

        if len(A_charge) == 1 and len(B_charge) == 1: continue
        elif A_charge[0] == B_charge[0]:
            total_charge += (charge_case[A_charge[0]] + max(charge_case[A_charge[1]], charge_case[B_charge[1]]))
        else:            
            total_charge += (charge_case[A_charge[0]] + charge_case[B_charge[0]])

    return total_charge

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
