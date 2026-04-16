#include <bits/stdc++.h>
using namespace std;

const int dy[] = {0, 0, 0, -1, 1};
const int dx[] = {0, 1, -1, 0, 0};
int dice_pos[4][3] = {
    {0, 2, 0},
    {4, 1, 3},
    {0, 5, 0},
    {0, 6, 0}
};
int dice[7] = {0, 0, 0, 0, 0, 0, 0};
int n, m, y, x, mp[20][20], k, input, ny, nx;
void change(int i){
    int temp = 0;
    if(i == 1){ // 동
        temp = dice_pos[1][0];
        dice_pos[1][0] = dice_pos[3][1];
        dice_pos[3][1] = dice_pos[1][2];
        dice_pos[1][2] = dice_pos[1][1];
        dice_pos[1][1] = temp;
    }
    else if(i == 2){ //서
        temp = dice_pos[1][2];
        dice_pos[1][2] = dice_pos[3][1];
        dice_pos[3][1] = dice_pos[1][0];
        dice_pos[1][0] = dice_pos[1][1];
        dice_pos[1][1] = temp;
    }
    else if(i == 3){ //북
        temp = dice_pos[3][1];
        dice_pos[3][1] = dice_pos[0][1];
        dice_pos[0][1] = dice_pos[1][1];
        dice_pos[1][1] = dice_pos[2][1];
        dice_pos[2][1] = temp;
    }
    else if(i == 4){ //남
        temp = dice_pos[3][1];
        dice_pos[3][1] = dice_pos[2][1];
        dice_pos[2][1] = dice_pos[1][1];
        dice_pos[1][1] = dice_pos[0][1];
        dice_pos[0][1] = temp;
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m >> y >> x >> k;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> mp[i][j];
        }
    }
    while(k--){
        cin >> input;
        ny = y + dy[input];
        nx = x + dx[input];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        change(input);
        if(mp[ny][nx] == 0){
            mp[ny][nx] = dice[dice_pos[3][1]];
            cout << dice[dice_pos[1][1]] << '\n';
            x = nx;
            y = ny;
        }
        else{
            dice[dice_pos[3][1]] = mp[ny][nx];
            mp[ny][nx] = 0;
            cout << dice[dice_pos[1][1]] << '\n';
            x = nx;
            y = ny;
        }
    }

    return 0;
}