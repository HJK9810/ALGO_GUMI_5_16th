# 회문 : 거꾸로 읽어도 똑같은 문장이나 낱말
T = 10
num_cnt = 8

for tc in range(1,T+1):
  word_num = int(input())
  arr = [list(input()) for _ in range(8)]
  cnt=0

  # row
  for i in range(num_cnt):
    for j in range(num_cnt-word_num+1):
      #row
      temp1 = arr[i][j:j+word_num]
      
      #column
      temp2 = [arr[j+k][i] for k in range(word_num)]

      if temp1 == temp1[::-1]:
        cnt += 1
      if temp2 == temp2[::-1]:
        cnt += 1

  print(f'#{tc} {cnt}')