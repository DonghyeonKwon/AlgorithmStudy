#include <bits/stdc++.h>
using namespace std;

int n, m, visited[2][1001][1001], _mn = 987654321;
bool flag = false;
const int dy[] = { -1, 0, 1, 0 };
const int dx[] = { 0, -1, 0, 1 };

int go(int y, int x){
    queue<pair<int, pair<int, int>>> q;
    q.push({0, {y, x}});
    visited[0][y][x] = 0;

    while(q.size()){
        int broken = q.front().first;
        tie(y,x) = q.front().second;
        q.pop();
        if(y == n && x == m) return visited[broken][y][x] + 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny <= 0 || nx <= 0 || ny > n || nx > m) continue;
            if(visited[0][ny][nx] == 1){
                if(broken == 0){
                    visited[broken+1][ny][nx] = visited[broken][y][x] + 1;
                    flag = true;
                    q.push({1, {ny, nx}});
                }
            }
            else if(visited[0][ny][nx] == 0){
                if(broken == 1 && visited[broken][ny][nx] > 0) continue;
                visited[broken][ny][nx] = visited[broken][y][x] + 1;
                q.push({broken, {ny, nx}});
            }
        }
    }
    return -1;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        string s;
        cin >> s;
        for(int j = 1; j <= m; j++){
            if(s[j-1] == '1') visited[0][i][j] = 1;
            else visited[0][i][j] = 0;
        }
    }
    cout << go(1, 1) << '\n';

    return 0;
}