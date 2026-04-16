#include <bits/stdc++.h>
using namespace std;

const int dy[] = { 0, 1, 0, -1 };
const int dx[] = { 1, 0, -1, 0 };

int n, m;
bool mp[100][100], air[100][100];
queue<pair<int, int>> cheeze, no_cheeze;

void dfs(int y, int x){
    if(air[y][x]) return;
    air[y][x] = true;

    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || nx >= m || ny >= n) continue;
        if(mp[ny][nx]) continue;
        if(air[ny][nx]) continue;
        dfs(ny, nx);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); cin.tie(NULL);

    cin >> n >> m;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> mp[i][j];
            if(mp[i][j]){
                cheeze.push({i,j});
            }
        }
    }
    int ret = 0;
    dfs(0, 0);
    while(cheeze.size()){
        ret++;
        queue<pair<int, int>> temp;

        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         cout << mp[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';

        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         cout << air[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';
        
        while(cheeze.size()){
            int cnt = 0;
            int y = cheeze.front().first;
            int x = cheeze.front().second;
            cheeze.pop();
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(air[ny][nx]) cnt++;
                if(cnt >= 2) break;
            }
            if(cnt >= 2){
                no_cheeze.push({y,x});
                mp[y][x] = 0;
            }
            else{
                temp.push({y,x});
            }
        }
        if(temp.size()) {
            swap(cheeze, temp);
            while(no_cheeze.size()){
                int y = no_cheeze.front().first;
                int x = no_cheeze.front().second;
                no_cheeze.pop();
                if(!air[y][x]) dfs(y,x); 
            }
        }
    }

    cout << ret << '\n';

    return 0;
}