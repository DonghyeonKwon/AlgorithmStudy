#include <bits/stdc++.h>
using namespace std;

int m, n, cnt_0 = 0, cnt_1 = 0, mp[1000][1000], _mx = 0;
bool visited[1000][1000];
queue<pair<int, int>> q;
const int dy[] = { 0, 1, 0, -1 };
const int dx[] = { 1, 0, -1, 0 };

void printV(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << mp[i][j] << ' ';
        }
        cout << '\n';
    }
    cout <<'\n';
}

void bfs(){
    while(q.size()){
        // printV();
        int x, y;
        tie(y, x) = q.front();
        q.pop();
        if(_mx < mp[y][x] - 1) _mx = mp[y][x] - 1;
        cnt_1++;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(mp[ny][nx] != 0) continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = true;
            mp[ny][nx] = mp[y][x] + 1;
            q.push({ny,nx});
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    memset(visited, false, sizeof(visited));

    cin >> m >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> mp[i][j];
            if(mp[i][j] == 0) cnt_0++;
            else if(mp[i][j] == 1){
                q.push({i,j});
                visited[i][j] = true;
                cnt_1--;
            }
        }
    }
    bfs();
    // cout << cnt_0 << ' ' << cnt_1 << '\n';
    if(cnt_0 == cnt_1) cout << _mx << '\n';
    else cout << -1 << '\n';

    return 0;
}