# 책장 정리 점수
T = int(input())

for tc in range(1,T+1):
  N = int(input())
  seats = list(map(int,input().split()))
  cnt = [0] * N
  for n in range(0,N):
    for j in range(n+1,N):
      if seats[n] > seats[j]:
        cnt[n] += 1
  max_cnt = max(cnt)
  print(f'#{tc} {max_cnt}')