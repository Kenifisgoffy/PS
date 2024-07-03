#include <iostream>
#include <vector>
#include <string>
#include <cmath>
#include <algorithm>
#define MAX 100001
#define FASTIO cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);

using namespace std;
struct QUERY {
    int Left, Right, Index;
};

int N, M, S, I, J;
int A[MAX];
vector<QUERY> Query;
int Value, Left, Right;
int Count[MAX], Count_Count[MAX];
int Answer[MAX];

void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> I >> J;
        Query.push_back({ I - 1,J - 1,i });
    }
}

bool Comp(QUERY A, QUERY B) {
    if (A.Left / S != B.Left / S) {
        return (A.Left / S < B.Left / S);
    }
    return (A.Right < B.Right);
}

void settings() {
    S = sqrt(N);
    sort(Query.begin(), Query.end(), Comp);
    Left = Query[0].Left;
    Right = Query[0].Right;
    for (int i = Left; i <= Right; i++) {
        int Now = A[i];
        Count_Count[Count[Now]]--;
        Count[Now]++;
        Value = max(Value, Count[Now]);
        Count_Count[Count[Now]]++;
    }
    Answer[Query[0].Index] = Value;
    for (int i = 1; i < M; i++) {
        while (Query[i].Left < Left) {
            Left--;
            int Now = A[Left];
            Count_Count[Count[Now]]--;
            Count[Now]++;
            Value = max(Value, Count[Now]);
            Count_Count[Count[Now]]++;
        };

        while (Query[i].Left > Left) {
            int Now = A[Left];
            Count_Count[Count[Now]]--;
            if ((Count_Count[Count[Now]] == 0) && (Value == Count[Now])) {
                Value--;
            }
            Count[Now]--;
            Count_Count[Count[Now]]++;
            Left++;
        };

        while (Query[i].Right > Right) {
            Right++;
            int Now = A[Right];
            Count_Count[Count[Now]]--;
            Count[Now]++;
            Value = max(Value, Count[Now]);
            Count_Count[Count[Now]]++;
        };

        while (Query[i].Right < Right) {
            int Now = A[Right];
            Count_Count[Count[Now]]--;
            if ((Count_Count[Count[Now]] == 0) && (Value == Count[Now])) {
                Value--;
            }
            Count[Now]--;
            Count_Count[Count[Now]]++;
            Right--;
        };

        Answer[Query[i].Index] = Value;
    }
}

void find_Answer() {
    for (int i = 0; i < M; i++) {
        cout << Answer[i] << "\n";
    }
}

int main() {
    FASTIO
    input();
    settings();
    find_Answer();

    return 0;
}