from collections import deque
import sys
input = sys.stdin.readline
#################################################
n = int(input())

# 수현이가 수행한 동작을 담아둔 변수(길이 n)
input_data = list(map(int, input().split()))

# 결과가 저장될 변수, 첫번째 카드는 따로 저장
answer_deck = deque()
frist_card = 1

# 바닥에 놓인 카드중 맨 위의 카드
now_card = 2

#명령의 역순으로 카드를 집어넣기
for index in range(n-2, -1, -1):
    order = input_data[index]
    if order == 1:
        answer_deck.appendleft(frist_card)
        frist_card = now_card

    elif order == 2:
        answer_deck.appendleft(now_card)

    elif order == 3:
        answer_deck.append(now_card)

    now_card += 1

print(frist_card, end = " ")
for num in answer_deck:
    print(num, end = " ")
