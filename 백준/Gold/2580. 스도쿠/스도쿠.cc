#include <bits/stdc++.h>
using namespace std;

int ans = (1 << 10) - 2;
vector<pair<int, int>> vp;
int s[9][9];
bool done = false;
int garo[9] = {0,0,0,0,0,0,0,0,0}, sero[9] = {0,0,0,0,0,0,0,0,0}, cell[3][3] = {{0,0,0},{0,0,0},{0,0,0}};

bool check(int y, int x, int i){
    if(garo[y] & (1 << i)) return false;
    if(sero[x] & (1 << i)) return false;
    if(cell[y/3][x/3] & (1 << i)) return false;
    return true;
}

void go(int cnt){
    if(done) return;
    if(cnt == vp.size()){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                cout << s[i][j] << ' ';
            }
            cout << '\n';
        }
        done = true;
        return;
    }

    int y = vp[cnt].first;
    int x = vp[cnt].second;

    int garo_temp = garo[y];
    int sero_temp = sero[x];
    int cell_temp = cell[y/3][x/3];
    for(int i = 1; i <= 9; i++){
        if(check(y, x, i)){
            garo[y] |= (1 << i);
            sero[x] |= (1 << i);
            cell[y/3][x/3] |= (1 << i);
            s[y][x] = i;
            go(cnt+1);
            if(done) return;
            s[y][x] = 0;
            garo[y] = garo_temp;
            sero[x] = sero_temp;
            cell[y/3][x/3] =  cell_temp;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            cin >> s[i][j];
            if(s[i][j] == 0){
                vp.push_back({i,j});
                continue;
            }
            garo[i] |= (1 << s[i][j]);
            sero[j] |= (1 << s[i][j]);
            cell[i/3][j/3] |= (1 << s[i][j]);
        }
    }

    go(0);

    // printf("%d\n", garo[0]);

    return 0;
}