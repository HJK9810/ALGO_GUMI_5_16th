T = 10

for tc in range(1,T+1):
  N, password = input().split()
  N = int(N)
  password = list(password)
  
  i = 0
  while i < N - 1:
    if password[i] == password[i+1]:
      del password[i:i+2]
      N -= 2
    else:
      i += 1

  print(f'#{tc} {"".join(password)}')