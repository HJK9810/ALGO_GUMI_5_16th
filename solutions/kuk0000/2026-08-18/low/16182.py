T = int(input())

for tc in range(1,T+1):
  N = int(input())
  scores = list(map(int,input()))

  count = [0 for _ in range(10)]
  for score in scores:
    count[score] += 1

  cnt_max = max(count)

  score_max = 9-count[::-1].index(max(count))

  print(f'#{tc} {score_max} {cnt_max}')