T = int(input())

for tc in range(1,T+1):
    array = input()
    stick = 0
    slices = 0

    for i in range(len(array)):
        if array[i] == "(":
            stick += 1
        else:
            stick -= 1
            if array[i-1] == "(":
                slices += stick
            else:
                slices += 1
    
    print(f'#{tc} {stick+slices}')