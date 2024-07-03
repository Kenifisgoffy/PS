#include <iostream>

using namespace std;

int main(){
	int r, c, res =0;

	cin >> r >> c;

	int ld[r][c], rd[r][c];

	char input; 

	for(int i=0; i<r; i++)
		for(int j=0; j<c; j++){
			cin >> input;
			if(input == '0'){
				ld[i][j] = 0;
				rd[i][j] = 0;
			}
			else{
				ld[i][j] = 1;
				rd[i][j] = 1;
			}
		}

	for(int i=r-2; i>=0; i--){
		for(int j=0; j<c; j++){
			if(ld[i][j] == 1 && j!= 0){
				ld[i][j] += ld[i+1][j-1];
			}
			if(rd[i][j] ==1 && j!= c-1){
				rd[i][j] += rd[i+1][j+1];
			}
		}
	}

	for(int i=0; i<r; i++){
		for(int j=0; j<c; j++){
			if(ld[i][j] !=0 && rd[i][j] !=0){
				res = max(res, 1);
				if(ld[i][j] != 1 && rd[i][j] != 1){
					int n = min(ld[i][j], rd[i][j]);
					while(n > 1){
						if(rd[i+n-1][j-n+1] >= n && ld[i+n-1][j+n-1]>=n){
							res = max(res, n);
						}
						n --;
					}
				}
			}
		}
	}
	cout << res << endl;
	return 0;
}