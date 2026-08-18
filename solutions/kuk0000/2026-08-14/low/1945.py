T = int(input())
for test_case in range(1,T+1):
  N = int(input())

  # arr = [0 for _ in range(5)]
  arr = (2, 3, 5, 7, 11)
  for i in range(5):
    rem=0
    while rem != 0 :
      rem = N%arr(i)
      i += 1

  print(f'#{test_case} {arr}')