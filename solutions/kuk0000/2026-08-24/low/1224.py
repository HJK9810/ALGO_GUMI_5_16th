T = int(input())

for tc in range(1,T+1):
  sentence = input()
  stack = []
  quote = None
  result = 1

  for char in sentence:

      # 따옴표 처리
      if char == "'" or char == '"':
        if quote is None:
            quote = char
        elif quote == char:
          quote = None
        continue

      # 문자열 내부라면
      if quote is not None:
        continue

      # 여는 괄호라면
      if char == "{" or char =="(" :
        stack.append(char)

      # 닫는 괄호라면
      if char == "}" or char ==")" :
        if not stack:
          result = 0
          break

        if char == ")":
          if stack[-1] == "(":
            stack.pop()
          else:
            result = 0
            break
        elif char == "}":
          if stack[-1] == "{":
            stack.pop()
          else:
            result = 0
            break
          
  if stack or quote is not None:
    result = 0

  print(f'#{tc} {result}')