#include <bits/stdc++.h>

using namespace std;

int t, m, n, k;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

void dfs(int y, int x, bool mp[][51], bool visited[][51]){
    visited[y][x] = true;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(visited[ny][nx]) continue;
        if(!mp[ny][nx]) continue;
        dfs(ny, nx, mp, visited);
    }
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    for(int i = 0; i < t; i++){
        cin >> m >> n >> k;
        bool mp[51][51] = {{0, }};
        bool visited[51][51] {{0, }};

        for(int j = 0; j < k; j++){
            int y, x;
            cin >> x >> y;
            mp[y][x] = true;
        }

        int ret = 0;
        for(int j = 0; j < n; j++){
            for(int k = 0; k < m; k++){
                if(mp[j][k] && !visited[j][k]){
                    // cout << "y : x -> " << j << " : " << k << '\n';
                    dfs(j, k, mp, visited);
                    ret++;
                }
            }
        }

        cout << ret << '\n';

    }

    return 0;
}