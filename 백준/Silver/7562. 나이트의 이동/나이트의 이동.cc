#include <bits/stdc++.h>
using namespace std;

const int dy[] = {2, 2, 1, 1, -1, -1, -2, -2};
const int dx[] = {1, -1, 2, -2, -2, 2, -1, 1};
int n = 0, ey, ex, _min = 987654321;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t;
    cin >> t;
    while(t--){
        _min = 987654321;
        cin >> n;
        int visited[n][n];
        memset(visited, 0, sizeof(visited));
        int y, x;
        cin >> y >> x;
        cin >> ey >> ex;
        queue<pair<int, int>> q;
        q.push({y,x});
        visited[y][x] = 1;
        while(q.size()){
            tie(y,x) = q.front();
            q.pop();
            if(y == ey && x == ex) _min = min(_min, visited[y][x] - 1);
            for(int i = 0; i < 8; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(visited[ny][nx] > 0) continue;
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny,nx});
            }
        }
        cout << _min << '\n';
    }

    return 0;
}