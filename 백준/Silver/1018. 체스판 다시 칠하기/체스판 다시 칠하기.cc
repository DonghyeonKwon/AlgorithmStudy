#include <bits/stdc++.h>

using namespace std;

string wb_board[8] ={
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
};

string bw_board[8] ={
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB"
};

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int m, n;
    cin >> m >> n;
    char board[m][n];

    for(int i = 0; i < m; i++){
        for(int j = 0;  j < n; j++){
            cin >> board[i][j];
        }
    }
    
    int count = 100000;
    for(int i = 0; i <= m - 8; i++){
        for(int j = 0; j <= n - 8; j++){
            int bw_cnt = 0, wb_cnt = 0, tmp = 0;

            for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                    if(board[i+y][j+x] != bw_board[y][x])
                        bw_cnt++;
                }
            }

            for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                    if(board[i+y][j+x] != wb_board[y][x])
                        wb_cnt++;
                }
            }

            tmp = min(bw_cnt, wb_cnt);
            if(count > tmp){
                count = tmp;
            }
        }
    }

    cout << count << '\n';

    return 0;
}