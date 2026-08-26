T = 10
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    '''

        이 부분에 여러분의 알고리즘 구현이 들어갑니다.

    '''
    # ///////////////////////////////////////////////////////////////////////////////////
    NN = input()
    nums = list(map(int, input().split()))
   # print(nums)
    idx = 0
    zero_idx = -1
    while True:
        s = nums[idx % 8]
        
        if (idx + 1) % 5 == 0:
            s = max(0, s - 5)
        else:
            s = max(0, s - ((idx + 1) % 5))
        nums[idx % 8] = s
        if (s == 0):
            zero_idx = idx % 8
            break
        
        idx += 1
     
    print('#' + str(test_case), end=' ')
    
    answer = []
    if zero_idx == 7:
        answer = nums
    else:
        answer = nums[zero_idx+1:] + nums[:zero_idx + 1]
    for num in answer:
        print(num, end=' ')
        
    print()