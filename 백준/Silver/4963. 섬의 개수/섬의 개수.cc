#include <bits/stdc++.h>
using namespace std;

const int dy[] = { 1, 0, -1, 0, 1, 1, -1, -1 };
const int dx[] = { 0, 1, 0, -1, 1, -1, 1, -1 };

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m;
    while(1){
        cin >> m >> n;
        if(n == 0 && m == 0) break;
        int cnt = 0, mp[n][m];
        bool visited[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cin >> mp[i][j];
                visited[i][j] = false;
            }
        }
        queue<pair<int,int>> q;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mp[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    q.push({i,j});
                }
                int x, y;
                while(q.size()){
                    tie(y, x) = q.front();
                    q.pop();
                    visited[y][x] = true;
                    for(int k = 0; k < 8; k++){
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if(visited[ny][nx]) continue;
                        if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                        if(mp[ny][nx] == 0) continue;
                        visited[ny][nx] = true;
                        q.push({ny,nx}); 
                    }
                }
            }
        }
        cout << cnt << '\n';
    }

    return 0;
}