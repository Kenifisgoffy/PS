N = int(input())
nums = list( map( int , input().split() ) )
v = int(input())
ans = 0 
for i in range(N): 
  if v == nums[i] : 
    ans += 1 

print(ans)