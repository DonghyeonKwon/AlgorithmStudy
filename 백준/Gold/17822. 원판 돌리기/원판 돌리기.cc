#include <bits/stdc++.h>
using namespace std;


int n, m, t, cir[51][51];
const int dy[] = {0, 1, 0, -1};
const int dx[] = {1, 0, -1, 0};
struct theme{
    int x, d, k;
}th[51];

void move(int x, int d, int k){
    for(int nx = x; nx <= n; nx += x){
        int temp[m+1];
        if(d == 0){
            for(int j = 1; j <= m; j++){             
                temp[((j+k) > m)? (j+k) % m : (j+k)] = cir[nx][j];
            }
        }
        else{
            for(int j = 1; j <= m; j++){
                int idx = j - k;
                if(idx <= 0) idx = m + idx;
                temp[idx] = cir[nx][j];
            }
        }
        for(int j = 1; j <= m; j++){
            cir[nx][j] = temp[j];
        }
    }
}

bool count(int temp[51][51]){
    bool flag = true;
    for(int y = 1; y <= n; y++){
        for(int x = 1; x <= m; x++){
            if(cir[y][x] == 0) continue;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny <= 0 || ny > n) continue;
                if(nx == 0) nx = m;
                if(nx == m+1) nx = 1;
                if(cir[ny][nx] == cir[y][x]) {
                    if(flag) flag = false;
                    temp[y][x] = 0;
                }
            }
        }
    }
    return flag;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m >> t;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            cin >> cir[i][j];
        }
    }

    for(int i = 0; i < t; i++){
        cin >> th[i].x >> th[i].d >> th[i].k;
    }
    for(int i = 0; i < t; i++){
        int x = th[i].x, d = th[i].d, k = th[i].k;
        move(x, d, k);

        int temp[51][51];
        for(int y = 1; y <= n; y++){
            for(int x = 1; x <= m; x++){
                temp[y][x] = cir[y][x];
            }
        }

        bool flag = count(temp);

        int sum = 0, cnt = 0;
        if(flag){
            for(int y = 1; y <= n; y++){
                for(int x = 1; x <= m; x++){
                    if(cir[y][x] != 0) {
                        sum += cir[y][x];
                        cnt++;
                    }
                }
            }
            double _avg = (double)sum/cnt;
            for(int y = 1; y <= n; y++){
                for(int x = 1; x <= m; x++){
                    if(cir[y][x] == 0) continue;
                    if(cir[y][x] > _avg){
                        cir[y][x]--;
                    }
                    else if(cir[y][x] < _avg){
                        cir[y][x]++;
                    }
                }
            }
        }
        else{
            for(int y = 1; y <= n; y++){
                for(int x = 1; x <= m; x++){
                    cir[y][x] = temp[y][x];
                }
            }
        }
    }

    int sum = 0;
    for(int y = 1; y <= n; y++){
        for(int x = 1; x <= m; x++){
            sum += cir[y][x];
        }
    }

    cout << sum << '\n';

    return 0;
}