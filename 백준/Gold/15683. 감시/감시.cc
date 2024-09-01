#include <bits/stdc++.h>
using namespace std;

const int dy[] = {0, 1, 0, -1};
const int dx[] = {1, 0, -1, 0};

struct camera{
    int y, x, num;
}c[9];

int n, m, t = 1, mp[8][8], _min = 64, cnt = 0;
bool visited[8][8] = {{false, }, };

int watching(int ny, int nx, int dy, int dx){
    int sum = 0;
    while(!(ny < 0 || nx < 0 || ny >= n || nx >= m)){
        if(mp[ny][nx] == 6) break;
        // cout << visited[ny][nx] << '\n';
        if(visited[ny][nx]){
            ny += dy;
            nx += dx;
            continue;
        }
        visited[ny][nx] = true;
        ny += dy;
        nx += dx;
        sum++;
    }
    // cout << sum << '\n';
    return sum;
}

void go(int idx, int k){
    if(idx == t){
        // cout << cnt << ' ' << cnt - k << '\n';
        _min = min(_min, (cnt - k));
        return;
    }

    bool temp[8][8];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            temp[i][j] = visited[i][j];
        }
    }

    int y = c[idx].y;
    int x = c[idx].x;
    int num = c[idx].num;
    int sum = 0;

    if(num == 5){
        for(int i = 0; i < 4; i++){
            sum += watching(y+dy[i], x+dx[i], dy[i], dx[i]);
        }
        
        go(idx+1, k+sum);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = temp[i][j];
            }
        }
    }
    else{
        for(int i = 0; i < 4; i++){
            sum = 0;
            if(num == 1){
                sum += watching(y+dy[i], x+dx[i], dy[i], dx[i]);
            }
            else if(num == 2){
                sum += watching(y+dy[i], x+dx[i], dy[i], dx[i]);
                sum += watching(y+dy[(i+2)%4], x+dx[(i+2)%4], dy[(i+2)%4], dx[(i+2)%4]);
            }
            else if(num == 3){
                sum += watching(y+dy[i], x+dx[i], dy[i], dx[i]);
                sum += watching(y+dy[(i+1)%4], x+dx[(i+1)%4], dy[(i+1)%4], dx[(i+1)%4]);
            }
            else if(num == 4){
                sum += watching(y+dy[i], x+dx[i], dy[i], dx[i]);
                sum += watching(y+dy[(i+1)%4], x+dx[(i+1)%4], dy[(i+1)%4], dx[(i+1)%4]);
                sum += watching(y+dy[(i+2)%4], x+dx[(i+2)%4], dy[(i+2)%4], dx[(i+2)%4]);
            }

            go(idx+1, k+sum);

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    visited[i][j] = temp[i][j];
                }
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    cnt = n * m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> mp[i][j];
            if(mp[i][j] != 0) { visited[i][j] = true; cnt--;}
            if(mp[i][j] != 0 && mp[i][j] != 6){
                c[t].y = i; c[t].x = j; c[t].num = mp[i][j];
                t++;
            }
        }
    }

    // for(int i = 0; i < n; i++){
    //     for(int j = 0; j < m; j++){
    //        cout << visited[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';
    
    go(1, 0);

    cout << _min << '\n';

    return 0;
}