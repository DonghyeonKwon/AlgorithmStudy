#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, k;

const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, -1, 0, 1};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> k;
    vector<vector<int>> v(n, vector<int>(n, 0));
    queue<pair<int, int>> q[10001];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> v[i][j];
            if(v[i][j] > 0) q[v[i][j]].push({i,j});
        }
    }

    int s, x, y;
    cin >> s >> x >> y;

    while(s--){
        for(int i = 1; i <= k; i++){
            int cnt = q[i].size();
            int cx, cy;
            while(cnt--){
                tie(cx, cy) = q[i].front();
                q[i].pop();

                for(int d = 0; d < 4; d++){
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(v[nx][ny] > 0) continue;
                    v[nx][ny] = i;
                    q[i].push({nx, ny});
                }
            }
        }
    }

    cout << v[x-1][y-1] << '\n';

    return 0;
}