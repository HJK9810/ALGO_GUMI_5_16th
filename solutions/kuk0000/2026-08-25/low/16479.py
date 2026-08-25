T = int(input())

for tc in range(1, T+1):
    boxes = list(input())
    i=0

    while i < len(boxes)-1:
        if boxes[i] == boxes[i+1]:
            boxes.pop(i+1)
            boxes.pop(i)

            if i>0:
                i -= 1
        else:
            i += 1


    print(f'#{tc} {len(boxes)}') 