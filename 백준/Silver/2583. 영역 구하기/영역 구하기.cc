#include <bits/stdc++.h>

using namespace std;

int m, n, t;
bool adj[101][101];
bool visited[101][101];
vector<int> v;
int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };

int go(int y, int x){
    int res = 1;
    queue<pair<int, int>> q;
    q.push(make_pair(y, x));
    visited[y][x] = true;
    while(q.size()){
        int a = q.front().first;
        int b = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int ny = a + dy[i];
            int nx = b + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(!visited[ny][nx] && adj[ny][nx]){
                res++;
                visited[ny][nx] = true;
                q.push(make_pair(ny, nx));
            }
        }
    }

    return res;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m >> t;

    fill(&adj[0][0], &adj[0][0] + 101 * 101, true);
    fill(&visited[0][0], &visited[0][0] + 101 * 101, false);

    for(int c = 0; c < t; c++){
        int sx, sy, ex, ey;
        cin >> sx >> sy >> ex >> ey;
        if(sy > ey) swap(sy,ey);
        if(sx > ex) swap(sx,ex);
        for(int i = sy; i < ey; i++){
            for(int j = sx; j < ex; j++){
                adj[i][j] = false;
            }
        }
    }

    int cnt = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(adj[i][j] && !visited[i][j]){
                int k = go(i, j);
                cnt++;
                v.push_back(k);
            }
        }
    }

    sort(v.begin(), v.end());

    cout << cnt << '\n';
    for(int i : v){
        cout << i << " ";
    }
    cout << '\n';
    
    return 0;
}