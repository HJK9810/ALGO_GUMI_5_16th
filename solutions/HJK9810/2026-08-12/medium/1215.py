def check_palindrome(word):
    words = list(word)
    left, right = 0, len(words) - 1
    while left < right:
        if words[left] != words[right]: return False
        left += 1
        right -= 1
    
    return True

def algorithm():
    N = int(input())
    boards = [list(input()) for _ in range(8)]
    count = 0

    for row in range(8):
        for col in range(8):
            if col <= 8 - N:
                first_word = boards[row][col:col + N]
                if check_palindrome(first_word): count += 1
            if row <= 8 - N:
                second_word = [boards[r][col] for r in range(row, row + N)]
                if check_palindrome(second_word): count += 1

    return count

# T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 11):
    print(f"#{test_case} {algorithm()}")
