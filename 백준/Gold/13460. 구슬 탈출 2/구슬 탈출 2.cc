#include <iostream>
#include <vector>
#include <tuple>
#include <queue>
#include <algorithm>
using namespace std;

struct info{
    int ry, rx, by, bx, cnt;
};

int n, m;
vector<vector<char>> mp(10, vector<char>(10));
vector<vector<vector<vector<bool>>>> visited(10, vector<vector<vector<bool>>>(10, vector<vector<bool>>(10, vector<bool>(10, false))));

const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, -1, 0, 1};

void move(int &y, int &x, int &c, int &i){
    while(mp[y + dy[i]][x + dx[i]] != '#' && mp[y][x] != 'O'){
        y += dy[i];
        x += dx[i];
        c++;
    }
}

void go(int ry, int rx, int by, int bx){
    queue<info> q;
    q.push({ry, rx, by, bx, 0});
    visited[ry][rx][by][bx] = true;
    int cnt;
    while(q.size()){
        ry = q.front().ry;
        rx = q.front().rx;
        by = q.front().by;
        bx = q.front().bx;
        cnt = q.front().cnt;
        q.pop();

        if(cnt >= 10) break;

        for(int i = 0; i < 4; i++){
            int nry = ry, nrx = rx, nby = by, nbx = bx;
            int rc = 0, bc = 0, ncnt = cnt + 1;

            move(nry, nrx, rc, i);
            move(nby, nbx, bc, i);

            if(mp[nby][nbx] == 'O') continue;
            if(mp[nry][nrx] == 'O'){
                cout << ncnt << '\n';
                return;
            }
            if(nry == nby && nrx == nbx){
                if(rc < bc) nby -= dy[i], nbx -= dx[i];
                else nry -= dy[i], nrx -= dx[i];
            }

            if(visited[nry][nrx][nby][nbx]) continue;
            visited[nry][nrx][nby][nbx] = true;
            q.push({nry, nrx, nby, nbx, ncnt});
        }
    }
    cout << -1 << '\n';
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    int ry, rx, by, bx;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> mp[i][j];
            if(mp[i][j] == 'R'){
                ry = i;
                rx = j;
            }
            else if(mp[i][j] == 'B'){
                by = i;
                bx = j;
            }
        }
    }

    go(ry, rx, by, bx);

    return 0;
}