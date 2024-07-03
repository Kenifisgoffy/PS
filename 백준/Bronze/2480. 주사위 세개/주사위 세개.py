A,B,C =  map(int , input().split())

if A == B == C :
  print(10000+A*1000)
elif A == B or  A == C :
  print(1000+ A * 100)

elif B == C : 
  print(1000 + B * 100)

else : 
  if ( A > B > C ) or ( A> C> B): 
    # A
    print(A * 100)
  elif (B > A > C ) or ( B > C > A) : 
    # B 
    print(B * 100)
  else : 
    # C 
    print (C * 100)