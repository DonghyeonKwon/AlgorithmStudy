#include <bits/stdc++.h>
using namespace std;
#define _MAX 987654321
int n, m, cnt_0 = 0, _min = _MAX;
int mp[50][50];
bool selectV[10];
vector<pair<int,int>> virus;
vector<vector<int>> visited;

const int dy[] = { -1, 0, 1, 0 };
const int dx[] = { 0, -1, 0, 1 };

void bfs(queue<pair<int, int>> &live_virus){
    int t = 0, cnt_1 = 0, x, y;
    while(live_virus.size()){
        tie(y, x) = live_virus.front();
        live_virus.pop();
        
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && nx >= 0 && ny < n && nx < n){
                if(mp[ny][nx] != 1 && visited[ny][nx] == 0){
                    visited[ny][nx] = visited[y][x] + 1;
                    if(mp[ny][nx] == 0){
                        t = visited[y][x];
                        cnt_1++;
                    }
                    live_virus.push({ny,nx});
                }
            }
        }
    }

    // cout << t << '\n';
    // for(int i = 0; i < n; i++){
    //     for(int j = 0; j < n; j++){
    //         cout << visited[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';

    if(cnt_0 == cnt_1){
        _min = min(_min, t);
    }

    return;
}

void go(int idx, int cnt){
    if(cnt == m){
        queue<pair<int, int >> q;
        visited.clear();
        visited.resize(n, vector<int>(n, 0));
        for(int i = 0; i < virus.size(); i++){
            if(selectV[i]){
                q.push(virus[i]);
                visited[virus[i].first][virus[i].second] = 1;
            }
        }
        bfs(q);
        return;
    }

    for(int i = idx; i < virus.size(); i++){
        if(selectV[i]) continue;
        selectV[i] = true;
        go(i+1, cnt+1);
        selectV[i] = false;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> mp[i][j];
            if(mp[i][j] == 0) cnt_0++;
            else if(mp[i][j] == 2) virus.push_back({i, j});
        }
    }
    fill(selectV, selectV + 10, false);
    go(0, 0);

    cout << ((_min == _MAX) ? -1 : _min) << '\n';

    return 0;
}