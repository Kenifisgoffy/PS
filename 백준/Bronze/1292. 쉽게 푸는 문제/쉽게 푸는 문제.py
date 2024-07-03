A,B =  map(int , input().split())
nums = []
for num in range (1, B+1):
    for tong in range (num):
        nums.append(num)    
    
ans = 0

for num in range(A - 1,B):
    ans += nums[num]
    
print (ans)