T = 10
for test_case in range(1,T+1):
    num = int(input())
    pattern = input().strip()     # 찾을 문자열
    sentence = input().strip()    # 검색할 문장

    N = len(sentence)
    L = len(pattern)
    count = 0

    for i in range(N - L + 1):
        if sentence[i:i+L] == pattern:
            count += 1

    print(f'#{num} {count}')