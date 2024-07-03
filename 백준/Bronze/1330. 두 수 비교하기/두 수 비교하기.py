hu = list(map(int,input().split())) 
if hu[0] < hu[1] :
  print("<")
elif hu[0] > hu[1] :
  print(">")
elif hu[0] == hu[1] :
  print("==")