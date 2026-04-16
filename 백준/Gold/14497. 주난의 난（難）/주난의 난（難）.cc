#include <bits/stdc++.h>
using namespace std;

char mp[303][303];
int n, m, cnt = 0;
vector<pair<int, int>> vp;
int cy, cx, jy, jx;
int visited[303][303];

const int dy[] = {0, 1, 0, -1};
const int dx[] = {1, 0, -1, 0};

void jump(int y, int x){
    deque<pair<int, int>> q;
    q.push_front({y,x});

    while(q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop_front();

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny == cy && nx == cx){
                cout << visited[y][x] <<'\n';
                return;
            }
            if(ny <= 0 || nx <= 0 || ny > n || nx > m) continue;
            if(visited[ny][nx]) continue;

            if(mp[ny][nx] == '0'){
                visited[ny][nx] = visited[y][x];
                q.push_front({ny, nx});
            }
            else if(mp[ny][nx] == '1'){
                visited[ny][nx] = visited[y][x] + 1;
                q.push_back({ny, nx});
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    cin >> jy >> jx >> cy >> cx;
    for(int i = 1; i <= n; i++){
        string str;
        cin >> str;
        for(int j = 1; j <= m; j++){
            mp[i][j] = str[j-1];
        }
    }

    fill(&visited[0][0], &visited[0][0] + (303 * 303), 0);
    vp.clear();
    visited[jy][jx] = 1;
    jump(jy, jx);
    
    // cout << visited[cy][cx] - 1 << '\n';

    return 0;
}