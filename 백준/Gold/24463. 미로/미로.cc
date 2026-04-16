#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
char mp[2001][2001];
bool visited[2001][2001], flag = false;
pair<int, int> p[2];

const int dy[] = {1, -1, 0, 0};
const int dx[] = {0, 0, 1, -1};

void go(int y, int x){
    if(y == p[1].first && x == p[1].second) {
        flag = true;
        return;
    }

    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        if(mp[ny][nx] == '+') continue;
        if(visited[ny][nx]) continue;
        visited[ny][nx] = true;
        go(ny,nx);
        if(flag) return;
        visited[ny][nx] = false;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    int cnt = 0;
    for(int i = 0; i < n; i++){
        string str;
        cin >> str;
        for(int j = 0; j < m; j++){
            mp[i][j] = str[j];
            visited[i][j] = false;
            if(mp[i][j] == '.' && (i == 0 || i == n - 1 || j == 0 || j == m - 1)){
                p[cnt++] = {i, j};
            }
        }
    }
    
    visited[p[0].first][p[0].second] = true;
    go(p[0].first, p[0].second);

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(mp[i][j] == '.'){
                if(visited[i][j]) cout << mp[i][j];
                else cout << '@';
            }
            else cout << mp[i][j];
        }
        cout << '\n';
    }
    cout << '\n';

    return 0;
}