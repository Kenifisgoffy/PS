directions = {
    'R': (0, 1),
    'L': (0, -1),
    'B': (-1, 0),
    'T': (1, 0),
    'RT': (1, 1),
    'LT': (1, -1),
    'RB': (-1, 1),
    'LB': (-1, -1)
}
def is_in_bounds(x, y):
    return 0 <= x < 8 and 0 <= y < 8

def move_piece(pos, direction):
    return (pos[0] + direction[0], pos[1] + direction[1])

def convert_position(pos):
    return chr(pos[1] + ord('A')) + str(pos[0] + 1)

def main():
    # 입력 받기
    king_pos, stone_pos, N = input().split()
    king_pos = (int(king_pos[1]) - 1, ord(king_pos[0]) - ord('A'))
    stone_pos = (int(stone_pos[1]) - 1, ord(stone_pos[0]) - ord('A'))
    N = int(N)

    # 이동 명령어들
    moves = []
    for _ in range(N):
        moves.append(input().strip())

    # 이동 처리
    for move in moves:
        direction = directions[move]
        new_king_pos = move_piece(king_pos, direction)

        if not is_in_bounds(*new_king_pos):
            continue

        if new_king_pos == stone_pos:
            new_stone_pos = move_piece(stone_pos, direction)
            if not is_in_bounds(*new_stone_pos):
                continue
            stone_pos = new_stone_pos

        king_pos = new_king_pos

    # 출력
    print(convert_position(king_pos))
    print(convert_position(stone_pos))

if __name__ == "__main__":
    main()
