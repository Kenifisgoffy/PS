x = int(input())
y = int(input())

if x > 0 and y > 0: # x,y가 모두 양수일 때
    print(1) # 1사분면
elif x < 0 and y > 0: # x가 음수, y가 양수일 때
    print(2) # 2사분면
elif x < 0 and y < 0: # x,y가 모두 음수일 때
    print(3) # 3사분면
else: # x가 양수, y가 음수일 때
    print(4) # 4사분면
