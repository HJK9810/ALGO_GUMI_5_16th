def check_triplet_first(cards):
    same_count = 0
    for num in range(10):
        if cards[num] >= 3:
            same_group_count = cards[num] // 3
            same_count += same_group_count
            cards[num] -= 3 * same_group_count

    order_count = 0
    for num in range(8):
        if cards[num] == 0: continue
        if cards[num] and cards[num + 1] and cards[num + 2]:
            group_count = min(cards[num], cards[num + 1], cards[num + 2])
            order_count += group_count
            cards[num] -= group_count
            cards[num + 1] -= group_count
            cards[num + 2] -= group_count

    return sum(cards) == 0

def check_run_first(cards):
    order_count = 0
    for num in range(8):
        if cards[num] == 0: continue
        if cards[num] and cards[num + 1] and cards[num + 2]:
            group_count = min(cards[num], cards[num + 1], cards[num + 2])
            order_count += group_count
            cards[num] -= group_count
            cards[num + 1] -= group_count
            cards[num + 2] -= group_count

    same_count = 0
    for num in range(10):
        if cards[num] >= 3:
            same_group_count = cards[num] // 3
            same_count += same_group_count
            cards[num] -= 3 * same_group_count

    return sum(cards) == 0

def algorithm():
    cards = list(map(int, input().strip()))

    count_cards = [0] * 10
    for card in cards:
        count_cards[int(card)] += 1

    return 'true' if (check_run_first(count_cards[:]) or check_triplet_first(count_cards[:])) else 'false'

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
